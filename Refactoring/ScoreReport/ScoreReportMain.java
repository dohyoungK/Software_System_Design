package before;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreReportMain {
	private static Scanner scanner = new Scanner(System.in) ;
	private List<Student> studentList = new ArrayList<Student>();

	public static void main(String[] args) {
		ScoreReportMain ui = new ScoreReportMain() ;
		
		boolean quit = false ;
		while ( quit != true ) {
			final int command = ui.getCommand() ;
			switch ( command ) {
			case 0: quit = true ; break ;
			case 1: ui.addStudent() ; break ;
			case 2: ui.addScores() ; break ;
			case 3: ui.showStudentReport() ; break ;
			case 4: ui.clearStudentScores() ; break ;
			case -1: ui.initialize() ; break ;
			default: break ;
			}
		}
		System.out.println("Bye");
	}
	private int getCommand() {		
		showCommand();
		
		final int command = scanner.nextInt() ;
		return command ;
	}
	private void showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t -1. Init");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. Add student");
		System.out.println("\t 2. Add scores");
		System.out.println("\t 3. Show student report");
		System.out.println("\t 4. Clear student scores");
	}
	
	private void initialize() {
		Student james = new Student("James") ;
		james.getScores().add(20) ;
		james.getScores().add(10) ;

		Student brown = new Student("Brown") ;
		brown.getScores().add(30) ;
		brown.getScores().add(10) ;
		brown.getScores().add(20) ;
		brown.getScores().add(60) ;
		brown.getScores().add(50) ;
		
		studentList.add(james) ;
		studentList.add(brown) ;
	}
	
	private String getStudentName() {
		System.out.println("Enter student name: ");
		String studentName = scanner.next() ;
		return studentName;
	}
	private Student findStudent(String studentName) {
		Student findResult = new Student("");
		
		for ( Student student : studentList ) {
			boolean isEqualName = student.getName().equals(studentName);
			if ( isEqualName ) 	findResult = student;	
		}
		
		return findResult;
	}
	
	private void addStudent() {
		String studentName = getStudentName();
		Student newStudent = new Student(studentName) ;
		studentList.add(newStudent) ;
	}
	private void addScores() {
		String studentName = getStudentName();
		
		Student student = findStudent(studentName);
		
		System.out.println("Enter scores( -1 for quit): ") ;
		while ( true ) {
			int score = scanner.nextInt() ;
			if ( score == -1 ) break ;

			student.getScores().add(score) ;
		}
	}
	
	private void showStudentReport() {
		String studentName = getStudentName();
		
		Student student = findStudent(studentName);
		
		int sum = 0 ;
		for ( Integer score: student.getScores()) {
			System.out.print(score + " ");
			sum += score ;
		}
		System.out.println("Sum: " + sum);
	}
	
	private void clearStudentScores() {
		String studentName = getStudentName();
		
		Student student = findStudent(studentName);
		student.getScores().clear();
		System.out.println("Score cleared");
	}
}