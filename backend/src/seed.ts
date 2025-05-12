import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import { UsersService } from './users/users.service';
import { TopicsService } from './quizzes/topics.service';

async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  const usersService = app.get(UsersService);
  const topicsService = app.get(TopicsService);

  // Create admin user if doesn't exist
  try {
    const existingAdmin = await usersService.findAdminByUsername('admin');
    
    if (!existingAdmin) {
      console.log('Creating admin user...');
      await usersService.createAdmin({
        username: 'admin',
        password: 'admin123',
        canManageUsers: true,
        canManageQuizzes: true,
        canManageResources: true,
      });
      console.log('Admin user created successfully');
    } else {
      console.log('Admin user already exists, skipping creation');
    }
  } catch (error) {
    console.error('Error creating admin user:', error);
  }

  // Create a test user if doesn't exist
  try {
    const existingUser = await usersService.findByUsername('testuser');
    
    if (!existingUser) {
      console.log('Creating test user...');
      await usersService.create({
        username: 'testuser',
        password: 'password123',
        resetA1: 'test answer 1',
        resetA2: 'test answer 2',
      });
      console.log('Test user created successfully');
    } else {
      console.log('Test user already exists, skipping creation');
    }
  } catch (error) {
    console.error('Error creating test user:', error);
  }

  // Create default topics if they don't exist
  try {
    const topics = [
      { label: 'Mathematics', topicKey: 'math' },
      { label: 'Science', topicKey: 'science' },
      { label: 'History', topicKey: 'history' },
      { label: 'Literature', topicKey: 'literature' },
    ];

    for (const topic of topics) {
      try {
        await topicsService.findByKey(topic.topicKey);
        console.log(`Topic ${topic.label} already exists, skipping creation`);
      } catch (error) {
        // If not found, create it
        if (error.status === 404) {
          console.log(`Creating topic ${topic.label}...`);
          await topicsService.create(topic);
          console.log(`Topic ${topic.label} created successfully`);
        } else {
          throw error;
        }
      }
    }
  } catch (error) {
    console.error('Error creating default topics:', error);
  }

  await app.close();
}

bootstrap(); 