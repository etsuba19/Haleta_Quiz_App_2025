import { Entity, Column, PrimaryGeneratedColumn, ManyToOne, OneToMany } from 'typeorm';
import { Topic } from './topic.entity';
import { Question } from './question.entity';

@Entity()
export class Quiz {
  @PrimaryGeneratedColumn('uuid')
  id: string;

  @Column()
  title: string;

  @Column({ nullable: true })
  description: string;

  @ManyToOne(() => Topic, topic => topic.quizzes)
  topic: Topic;

  @OneToMany(() => Question, question => question.quiz, { cascade: true })
  questions: Question[];
} 