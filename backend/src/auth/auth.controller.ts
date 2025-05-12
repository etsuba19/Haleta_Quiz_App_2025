import { Controller, Post, Body, UseGuards, Request, Put } from '@nestjs/common';
import { AuthService } from './auth.service';
import { LocalAuthGuard } from './guards/local-auth.guard';
import { UsersService } from '../users/users.service';
import { CreateUserDto } from '../users/dto/create-user.dto';

class LoginDto {
  username: string;
  password: string;
}

class ResetPasswordDto {
  username: string;
  resetA1: string;
  resetA2: string;
  newPassword: string;
}

@Controller('auth')
export class AuthController {
  constructor(
    private readonly authService: AuthService,
    private readonly usersService: UsersService,
  ) {}

  @Post('register')
  async register(@Body() createUserDto: CreateUserDto) {
    return this.usersService.create(createUserDto);
  }

  @UseGuards(LocalAuthGuard)
  @Post('login')
  async login(@Request() req) {
    return this.authService.login(req.user);
  }

  @Put('reset-password')
  async resetPassword(@Body() resetPasswordDto: ResetPasswordDto) {
    const { username, resetA1, resetA2, newPassword } = resetPasswordDto;
    const user = await this.authService.validateUserByResetAnswers(username, resetA1, resetA2);
    
    if (user) {
      return this.usersService.resetPassword(user.id, newPassword);
    }
    
    return { success: false, message: 'Invalid reset answers' };
  }
} 