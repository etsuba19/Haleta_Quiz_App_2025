import { Injectable } from '@nestjs/common';
import { PassportStrategy } from '@nestjs/passport';
import { ExtractJwt, Strategy } from 'passport-jwt';
import { UsersService } from '../../users/users.service';

@Injectable()
export class JwtStrategy extends PassportStrategy(Strategy) {
  constructor(private usersService: UsersService) {
    super({
      jwtFromRequest: ExtractJwt.fromAuthHeaderAsBearerToken(),
      ignoreExpiration: false,
      secretOrKey: 'haleta-quiz-app-jwt-secret', // In production, use an environment variable
    });
  }

  async validate(payload: any) {
    // If admin, return admin data
    if (payload.isAdmin) {
      const admin = await this.usersService.findAdminByUsername(payload.username);
      if (admin) {
        return { 
          username: admin.username,
          isAdmin: true,
          permissions: {
            canManageUsers: admin.canManageUsers,
            canManageQuizzes: admin.canManageQuizzes,
            canManageResources: admin.canManageResources,
          }
        };
      }
    }
    
    // Otherwise, return user data
    return { 
      userId: payload.sub,
      username: payload.username,
      isAdmin: false,
    };
  }
} 