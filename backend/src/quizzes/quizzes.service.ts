import { Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Quiz } from './entities/quiz.entity';
import { Question } from './entities/question.entity';
import { CreateQuizDto } from './dto/create-quiz.dto';
import { TopicsService } from './topics.service';

@Injectable()
export class QuizzesService {
  constructor(
    @InjectRepository(Quiz)
    private quizzesRepository: Repository<Quiz>,
    @InjectRepository(Question)
    private questionsRepository: Repository<Question>,
    private topicsService: TopicsService,
  ) {}

  async create(createQuizDto: CreateQuizDto): Promise<Quiz> {
    const { topicId, questions, ...quizData } = createQuizDto;
    
    const topic = await this.topicsService.findOne(topicId);
    if (!topic) {
      throw new NotFoundException(`Topic with ID ${topicId} not found`);
    }

    const quiz = this.quizzesRepository.create({
      ...quizData,
      topic,
      questions: questions.map(q => this.questionsRepository.create(q)),
    });

    return this.quizzesRepository.save(quiz);
  }

  async findAll(): Promise<Quiz[]> {
    return this.quizzesRepository.find({
      relations: ['topic', 'questions'],
    });
  }

  async findByTopic(topicId: string): Promise<Quiz[]> {
    return this.quizzesRepository.find({
      where: { topic: { id: topicId } },
      relations: ['topic', 'questions'],
    });
  }

  async findOne(id: string): Promise<Quiz> {
    const quiz = await this.quizzesRepository.findOne({
      where: { id },
      relations: ['topic', 'questions'],
    });
    
    if (!quiz) {
      throw new NotFoundException(`Quiz with ID ${id} not found`);
    }
    
    return quiz;
  }

  async remove(id: string): Promise<void> {
    const result = await this.quizzesRepository.delete(id);
    
    if (result.affected === 0) {
      throw new NotFoundException(`Quiz with ID ${id} not found`);
    }
  }
} 