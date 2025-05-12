import { Entity, Column, PrimaryGeneratedColumn, OneToMany } from 'typeorm';
import { Quiz } from './quiz.entity';
import { ReadingMaterial } from '../../reading-materials/entities/reading-material.entity';

@Entity()
export class Topic {
  @PrimaryGeneratedColumn('uuid')
  id: string;

  @Column()
  label: string;

  @Column({ unique: true })
  topicKey: string;

  @OneToMany(() => Quiz, quiz => quiz.topic)
  quizzes: Quiz[];

  @OneToMany(() => ReadingMaterial, material => material.topic)
  readingMaterials: ReadingMaterial[];
} 