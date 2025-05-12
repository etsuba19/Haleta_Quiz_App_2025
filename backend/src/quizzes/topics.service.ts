import { Injectable, NotFoundException, ConflictException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Topic } from './entities/topic.entity';
import { CreateTopicDto } from './dto/create-topic.dto';

@Injectable()
export class TopicsService {
  constructor(
    @InjectRepository(Topic)
    private topicsRepository: Repository<Topic>,
  ) {}

  async create(createTopicDto: CreateTopicDto): Promise<Topic> {
    const existingTopic = await this.topicsRepository.findOne({
      where: { topicKey: createTopicDto.topicKey },
    });

    if (existingTopic) {
      throw new ConflictException(`Topic with key ${createTopicDto.topicKey} already exists`);
    }

    const topic = this.topicsRepository.create(createTopicDto);
    return this.topicsRepository.save(topic);
  }

  async findAll(): Promise<Topic[]> {
    return this.topicsRepository.find();
  }

  async findOne(id: string): Promise<Topic> {
    const topic = await this.topicsRepository.findOne({
      where: { id },
      relations: ['quizzes', 'readingMaterials'],
    });
    
    if (!topic) {
      throw new NotFoundException(`Topic with ID ${id} not found`);
    }
    
    return topic;
  }

  async findByKey(topicKey: string): Promise<Topic> {
    const topic = await this.topicsRepository.findOne({
      where: { topicKey },
      relations: ['quizzes', 'readingMaterials'],
    });
    
    if (!topic) {
      throw new NotFoundException(`Topic with key ${topicKey} not found`);
    }
    
    return topic;
  }

  async remove(id: string): Promise<void> {
    const result = await this.topicsRepository.delete(id);
    
    if (result.affected === 0) {
      throw new NotFoundException(`Topic with ID ${id} not found`);
    }
  }
} 