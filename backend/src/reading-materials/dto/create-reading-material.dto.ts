import { IsString, IsNotEmpty, IsOptional, IsUUID } from 'class-validator';

export class CreateReadingMaterialDto {
  @IsString()
  @IsNotEmpty()
  title: string;

  @IsString()
  @IsNotEmpty()
  content: string;

  @IsString()
  @IsOptional()
  imageUrl?: string;

  @IsUUID()
  @IsNotEmpty()
  topicId: string;
} 