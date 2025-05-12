import { Controller, Get, Post, Body, Param, Delete, UseGuards, Query, NotFoundException } from '@nestjs/common';
import { ReadingMaterialsService } from './reading-materials.service';
import { CreateReadingMaterialDto } from './dto/create-reading-material.dto';
import { JwtAuthGuard } from '../auth/guards/jwt-auth.guard';
import { AdminGuard } from '../auth/guards/admin.guard';
import { TopicsService } from '../quizzes';

@Controller('reading-materials')
export class ReadingMaterialsController {
  constructor(
    private readonly readingMaterialsService: ReadingMaterialsService,
    private readonly topicsService: TopicsService,
  ) {}

  @UseGuards(JwtAuthGuard, AdminGuard)
  @Post()
  async create(@Body() createDto: CreateReadingMaterialDto) {
    const topic = await this.topicsService.findOne(createDto.topicId);
    if (!topic) {
      throw new NotFoundException(`Topic with ID ${createDto.topicId} not found`);
    }
    
    return this.readingMaterialsService.create(createDto, topic);
  }

  @UseGuards(JwtAuthGuard)
  @Get()
  async findAll(@Query('topicId') topicId?: string) {
    if (topicId) {
      return this.readingMaterialsService.findByTopic(topicId);
    }
    return this.readingMaterialsService.findAll();
  }

  @UseGuards(JwtAuthGuard)
  @Get(':id')
  async findOne(@Param('id') id: string) {
    return this.readingMaterialsService.findOne(id);
  }

  @UseGuards(JwtAuthGuard, AdminGuard)
  @Delete(':id')
  async remove(@Param('id') id: string) {
    await this.readingMaterialsService.remove(id);
    return { success: true };
  }
} 