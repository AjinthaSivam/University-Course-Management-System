# API Testing Guide for Role-Based Authentication

## Overview
This guide explains how to test the implemented role-based authentication system.

## Default Admin Credentials
- **Email**: admin@university.edu
- **Password**: admin123

## API Endpoints

### 1. Login (Public)
**POST** `/api/auth/login`
```json
{
  "email": "admin@university.edu",
  "password": "admin123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "role": "ADMIN",
  "email": "admin@university.edu",
  "name": "System Administrator",
  "studentNumber": null
}
```

### 2. Register Student (Public - Admin only in practice)
**POST** `/api/auth/register-student`
```json
{
  "name": "John Doe",
  "email": "john.doe@university.edu",
  "studentNumber": "STU001",
  "password": "student123"
}
```

### 3. Create Admin (Public - for initial setup)
**POST** `/api/auth/create-admin`
```json
{
  "name": "Another Admin",
  "email": "admin2@university.edu",
  "password": "admin456"
}
```

### 4. Student Management (Protected)

#### Get All Students (Admin or Student)
**GET** `/api/students`
**Headers:** `Authorization: Bearer <token>`

#### Create Student (Admin only)
**POST** `/api/students`
**Headers:** `Authorization: Bearer <admin_token>`
```json
{
  "name": "Jane Smith",
  "email": "jane.smith@university.edu",
  "studentNumber": "STU002"
}
```

#### Update Student (Admin only)
**PUT** `/api/students/{id}`
**Headers:** `Authorization: Bearer <admin_token>`

#### Delete Student (Admin only)
**DELETE** `/api/students/{id}`
**Headers:** `Authorization: Bearer <admin_token>`

## Testing Workflow

1. **Start the application**
2. **Login as admin** using the default credentials
3. **Register a student** using the admin token
4. **Login as the student** to get student token
5. **Test role-based access**:
   - Admin can create/update/delete students
   - Students can only view students
   - Both can access other endpoints (courses, results, etc.)

## Security Features

- **JWT Token Authentication**: All protected endpoints require valid JWT token
- **Role-Based Access Control**: Different permissions for ADMIN and STUDENT roles
- **Password Encryption**: All passwords are encrypted using BCrypt
- **CORS Enabled**: Frontend can make requests from any origin

## Error Responses

- **401 Unauthorized**: Invalid or missing token
- **403 Forbidden**: Valid token but insufficient permissions
- **400 Bad Request**: Invalid request data or validation errors


