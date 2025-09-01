import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CourseList: React.FC = () => {
    const [courses, setCourses] = useState([]);
    const [newCourse, setNewCourse] = useState({ title: '', code: '' });

    // Fetch courses on mount
    useEffect(() => {
        fetchCourses();
    }, []);

    const fetchCourses = async () => {
        try {
            const response = await axios.get('http://localhost:8081/api/courses');
            setCourses(response.data);
        } catch (error) {
            console.error('Error fetching courses:', error);
        }
    };

    // Handle form input changes
    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setNewCourse({ ...newCourse, [name]: value });
    };

    // Add a new course
    const handleAddCourse = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8081/api/courses', newCourse);
            setNewCourse({ title: '', code: '' }); // Clear form
            fetchCourses(); // Refresh list
        } catch (error) {
            console.error('Error adding course:', error);
        }
    };

    return (
        <div className="container mx-auto p-4">
            <h1 className="text-2xl font-bold mb-4 text-gray-800">Course Management</h1>

            {/* Add Course Form */}
            <form onSubmit={handleAddCourse} className="mb-6">
                <div className="grid grid-cols-2 gap-4">
                    <input
                        type="text"
                        name="title"
                        value={newCourse.title}
                        onChange={handleInputChange}
                        placeholder="Course Title"
                        className="border p-2 rounded"
                    />
                    <input
                        type="text"
                        name="code"
                        value={newCourse.code}
                        onChange={handleInputChange}
                        placeholder="Course Code"
                        className="border p-2 rounded"
                    />
                    <button
                        type="submit"
                        className="col-span-2 bg-blue-500 text-white p-2 rounded hover:bg-blue-600"
                    >
                        Add Course
                    </button>
                </div>
            </form>

            {/* Course Table */}
            <div className="overflow-x-auto">
                <table className="min-w-full bg-white border border-gray-200">
                    <thead>
                    <tr className="bg-gray-100">
                        <th className="border p-2">ID</th>
                        <th className="border p-2">Title</th>
                        <th className="border p-2">Code</th>
                    </tr>
                    </thead>
                    <tbody>
                    {courses.map((course: any) => (
                        <tr key={course.id} className="hover:bg-gray-50">
                            <td className="border p-2">{course.id}</td>
                            <td className="border p-2">{course.title}</td>
                            <td className="border p-2">{course.code}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default CourseList;