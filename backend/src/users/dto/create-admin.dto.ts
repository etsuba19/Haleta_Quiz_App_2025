import { IsString, MinLength, IsNotEmpty, IsBoolean, IsOptional } from 'class-validator';

export class CreateAdminDto {
  @IsString()
  @IsNotEmpty()
  username: string;

  @IsString()
  @MinLength(6)
  password: string;

  @IsBoolean()
  @IsOptional()
  canManageUsers?: boolean;

  @IsBoolean()
  @IsOptional()
  canManageQuizzes?: boolean;

  @IsBoolean()
  @IsOptional()
  canManageResources?: boolean;
} 