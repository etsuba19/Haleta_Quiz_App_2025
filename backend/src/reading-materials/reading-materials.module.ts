import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ReadingMaterial } from './entities/reading-material.entity';
import { ReadingMaterialsService } from './reading-materials.service';
import { ReadingMaterialsController } from './reading-materials.controller';
import { QuizzesModule } from '../quizzes/quizzes.module';

@Module({
  imports: [
    TypeOrmModule.forFeature([ReadingMaterial]),
    QuizzesModule,
  ],
  providers: [ReadingMaterialsService],
  controllers: [ReadingMaterialsController],
  exports: [ReadingMaterialsService],
})
export class ReadingMaterialsModule {} 