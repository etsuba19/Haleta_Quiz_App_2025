import { Entity, Column, PrimaryGeneratedColumn, ManyToOne } from 'typeorm';
import { Topic } from '../../quizzes/entities/topic.entity';

@Entity()
export class ReadingMaterial {
  @PrimaryGeneratedColumn('uuid')
  id: string;

  @Column()
  title: string;

  @Column('text')
  content: string;

  @Column({ nullable: true })
  imageUrl: string;

  @ManyToOne(() => Topic, topic => topic.readingMaterials)
  topic: Topic;
} 