import { IsString, IsNotEmpty } from 'class-validator';

export class CreateTopicDto {
  @IsString()
  @IsNotEmpty()
  label: string;

  @IsString()
  @IsNotEmpty()
  topicKey: string;
} 