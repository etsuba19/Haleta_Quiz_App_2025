import { Injectable, UnauthorizedException } from '@nestjs/common';
import { JwtService } from '@nestjs/jwt';
import { UsersService } from '../users/users.service';
import { User } from '../users/entities/user.entity';
import { Admin } from '../users/entities/admin.entity';

@Injectable()
export class AuthService {
  constructor(
    private usersService: UsersService,
    private jwtService: JwtService,
  ) {}

  async validateUser(username: string, password: string): Promise<User | Admin | null> {
    // Try to find user first
    const user = await this.usersService.findByUsername(username);
    if (user && await user.validatePassword(password)) {
      return user;
    }

    // If not found, try to find admin
    const admin = await this.usersService.findAdminByUsername(username);
    if (admin && await admin.validatePassword(password)) {
      return admin;
    }

    return null;
  }

  async login(user: User | Admin) {
    const isAdmin = 'canManageUsers' in user;
    
    const payload = { 
      username: user.username, 
      sub: isAdmin ? null : user.id,
      isAdmin: isAdmin,
    };
    
    return {
      access_token: this.jwtService.sign(payload),
      user: {
        id: isAdmin ? null : user.id,
        username: user.username,
        isAdmin: isAdmin,

        ...(isAdmin && {   
          permissions: {
            canManageUsers: (user as Admin).canManageUsers,
            canManageQuizzes: (user as Admin).canManageQuizzes,
            canManageResources: (user as Admin).canManageResources,
          }
        })
      }
    };
  }

  async validateUserByResetAnswers(username: string, resetA1: string, resetA2: string): Promise<User | null> {
    const user = await this.usersService.findByUsername(username);
    if (!user) {
      throw new UnauthorizedException('User not found');
    }

    if (user.resetA1 === resetA1 && user.resetA2 === resetA2) {
      return user;
    }

    return null;
  }
} 