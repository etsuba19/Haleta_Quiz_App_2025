import { Controller, Get, Post, Body, Param, Delete, UseGuards } from '@nestjs/common';
import { TopicsService } from './topics.service';
import { CreateTopicDto } from './dto/create-topic.dto';
import { JwtAuthGuard } from '../auth/guards/jwt-auth.guard';
import { AdminGuard } from '../auth/guards/admin.guard';

@Controller('topics')
export class TopicsController {
  constructor(private readonly topicsService: TopicsService) {}

  @UseGuards(JwtAuthGuard, AdminGuard)
  @Post()
  async create(@Body() createTopicDto: CreateTopicDto) {
    return this.topicsService.create(createTopicDto);
  }

  @UseGuards(JwtAuthGuard)
  @Get()
  async findAll() {
    return this.topicsService.findAll();
  }

  @UseGuards(JwtAuthGuard)
  @Get(':id')
  async findOne(@Param('id') id: string) {
    return this.topicsService.findOne(id);
  }

  @UseGuards(JwtAuthGuard)
  @Get('key/:topicKey')
  async findByKey(@Param('topicKey') topicKey: string) {
    return this.topicsService.findByKey(topicKey);
  }

  @UseGuards(JwtAuthGuard, AdminGuard)
  @Delete(':id')
  async remove(@Param('id') id: string) {
    await this.topicsService.remove(id);
    return { success: true };
  }
} 