package com.thelaunchclub.dao;

import com.thelaunchclub.exception.InvalidQueryException;
import com.thelaunchclub.InvalidStudentDataException;
import com.thelaunchclub.StudentDbConnection;
import com.thelaunchclub.model.Student;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Implements the SQL query and connect it with the database.
 */

public class StudentDaoImpl implements StudentDao {

	private static final StudentDbConnection DB_CONNECTION = new StudentDbConnection();
	/**
	 * Insert student data's to the database for the specified roll number.
	 * 
	 * @param student
	 */
	public boolean insertStudent(final Student student) {
		final String insertQuery = "INSERT INTO student(roll_no, name, phone_number, branch, admission_date, is_active) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection connection = DB_CONNECTION.getConnection();
			 PreparedStatement statement = connection.prepareStatement(insertQuery);) {
			statement.setInt(1, student.getRollNo());
			statement.setString(2, student.getName());
			statement.setLong(3, student.getPhoneNumber());
			statement.setString(4, student.getBranch());
			statement.setDate(5, student.getAdmissionDate());
			statement.setBoolean(6, true);

			return statement.executeUpdate() > 0;
		} catch (SQLException exception) {
			throw new InvalidQueryException(exception.getMessage());
		} catch (Exception exception) {
			throw new InvalidStudentDataException(exception.getMessage());
		}
	}

	/**
	 * Fetch student data from the database by using roll number.
	 * 
	 * @param rollNo
	 */
	public Student selectStudent(final int rollNo) {

		final String selectQuery = "SELECT roll_no, name, phone_number, branch, admission_date FROM student WHERE is_active = true AND roll_no =?";

		try (Connection connection = DB_CONNECTION.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery);) {
			statement.setInt(1, rollNo);

			try (ResultSet resultSet = statement.executeQuery();) {
				Student student = null;

				while (resultSet.next()) {
					final String name = resultSet.getString(2);
					final long phoneNumber = resultSet.getLong(3);
					final String branch = resultSet.getString(4);
					final Date admissionDate = resultSet.getDate(5);
					student = new Student(rollNo, name, phoneNumber, branch, admissionDate);
				}
				return student;
			}
		} catch (SQLException exception) {
			throw new InvalidQueryException(exception.getMessage());
		}
	}

	/**
	 * Delete student data from the database.
	 * 
	 * @param rollNo
	 */
	public boolean deleteStudent(final int rollNo) {
		final String deleteQuery = "UPDATE student SET is_active = ? WHERE roll_no = ?";

		try (Connection connection = DB_CONNECTION.getConnection();
				PreparedStatement statement = connection.prepareStatement(deleteQuery);) {
			statement.setBoolean(1, false);
			statement.setInt(2, rollNo);

			return statement.executeUpdate() > 0;
		} catch (SQLException exception) {
			throw new InvalidQueryException(exception.getMessage());
		}
	}

	/**
	 * Update student data for the specified roll number.
	 * 
	 * @param student
	 */
	public boolean updateStudent(final Student student) {
		final StringBuilder queryBuilder = new StringBuilder();
		String updateQuery = queryBuilder.append("UPDATE student SET").toString();
		boolean hasNextData = false;
		int name = 1, branch = 1, phoneNo = 1, date = 1, rollNo = 1, count = 0;

		try (Connection connection = DB_CONNECTION.getConnection();) {

			if (student.getName() != null) {
				updateQuery = queryBuilder.append(" name= ").append("?").toString();
				hasNextData = true;
				count += 1;
			}

			if (student.getBranch() != null) {

				if (hasNextData) {
					updateQuery = queryBuilder.append(",").toString();
					branch = count + 1;
				}
				updateQuery = queryBuilder.append(" branch = ").append("?").toString();
				hasNextData = true;
				count += 1;
			}

			if (student.getPhoneNumber() != 0) {

				if (hasNextData) {
					updateQuery = queryBuilder.append(",").toString();
					phoneNo = count + 1;
				}
				updateQuery = queryBuilder.append(" phone_number = ").append("?").toString();
				hasNextData = true;
				count += 1;
			}

			if (student.getAdmissionDate() != null) {

				if (hasNextData) {
					updateQuery = queryBuilder.append(",").toString();
					date = count + 1;
				}
				updateQuery = queryBuilder.append(" admission_date = ").append("?").toString();
				count += 1;
			}
			updateQuery = queryBuilder.append(" WHERE roll_no = ").append("?").toString();
			rollNo = count + 1;
			
			try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);) {

				if (student.getName() != null) {
					preparedStatement.setString(name, student.getName());
				}

				if (student.getBranch() != null) {
					preparedStatement.setString(branch, student.getBranch());
				}

				if (student.getPhoneNumber() != 0) {
					preparedStatement.setLong(phoneNo, student.getPhoneNumber());
				}

				if (student.getAdmissionDate() != null) {
					preparedStatement.setDate(date, student.getAdmissionDate());
				}
				preparedStatement.setInt(rollNo, student.getRollNo());
				return preparedStatement.execute();
			}
		} catch (SQLException exception) {
			throw new InvalidQueryException(exception.getMessage());
		}
	}

	/**
	 * Fetch all student data from database.
	 */
	public Map<Integer, Student> selectAllStudents() {
		final String selectAllQuery = "SELECT roll_no, name, phone_number, branch, admission_date FROM student WHERE is_active = true";
		final Map<Integer, Student> students = new HashMap<>();

		try (Connection connection = DB_CONNECTION.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectAllQuery);
				ResultSet resultSet = preparedStatement.executeQuery();) {

			while (resultSet.next()) {
				final int rollNumber = resultSet.getInt(1);
				final String name = resultSet.getString(2);
				final Long phoneNumber = resultSet.getLong(3);
				final String branch = resultSet.getString(4);
				final Date admissionDate = resultSet.getDate(5);

				students.put(rollNumber, new Student(rollNumber, name, phoneNumber, branch, admissionDate));
			}
			return students;
		} catch (SQLException exception) {
			throw new InvalidQueryException(exception.getMessage());
		}
	}
}
