import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { join } from 'path';
import { UsersModule } from './users/users.module';
import { AuthModule } from './auth/auth.module';
import { QuizzesModule } from './quizzes/quizzes.module';
import { ReadingMaterialsModule } from './reading-materials/reading-materials.module';

@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: 'sqlite',
      database: join(__dirname, '..', 'data', 'quiz-app.sqlite'),
      entities: [__dirname + '/**/*.entity{.ts,.js}'],
      synchronize: true, // Only for development, disable in production
    }),
    UsersModule,
    QuizzesModule,
    AuthModule,
    ReadingMaterialsModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
