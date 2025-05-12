import { Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { ReadingMaterial } from './entities/reading-material.entity';
import { CreateReadingMaterialDto } from './dto/create-reading-material.dto';

@Injectable()
export class ReadingMaterialsService {
  constructor(
    @InjectRepository(ReadingMaterial)
    private readingMaterialsRepository: Repository<ReadingMaterial>,
  ) {}

  async create(createDto: CreateReadingMaterialDto, topic: any): Promise<ReadingMaterial> {
    const { topicId, ...materialData } = createDto;
    
    const material = this.readingMaterialsRepository.create({
      ...materialData,
      topic,
    });

    return this.readingMaterialsRepository.save(material);
  }

  async findAll(): Promise<ReadingMaterial[]> {
    return this.readingMaterialsRepository.find({
      relations: ['topic'],
    });
  }

  async findByTopic(topicId: string): Promise<ReadingMaterial[]> {
    return this.readingMaterialsRepository.find({
      where: { topic: { id: topicId } },
      relations: ['topic'],
    });
  }

  async findOne(id: string): Promise<ReadingMaterial> {
    const material = await this.readingMaterialsRepository.findOne({
      where: { id },
      relations: ['topic'],
    });
    
    if (!material) {
      throw new NotFoundException(`Reading material with ID ${id} not found`);
    }
    
    return material;
  }

  async remove(id: string): Promise<void> {
    const result = await this.readingMaterialsRepository.delete(id);
    
    if (result.affected === 0) {
      throw new NotFoundException(`Reading material with ID ${id} not found`);
    }
  }
} 