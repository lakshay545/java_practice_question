# java_practice_question
👉 How this code works

Classes

I made a Person class (it has only name).

Then I made a Student class which extends Person.

In Student, I added roll number, course, marks, and grade.

Methods

inputDetails() → takes details from user (roll no, name, course, marks).

calculateGrade() → checks marks and gives grade:

Marks ≥ 90 → A

Marks ≥ 75 → B

Marks ≥ 50 → C

Else → D

displayDetails() → shows the student information.

Main Program

I created StudentRecordSystem class with main() method.

It has a menu with 3 choices:

Add Student

Display All Students

Exit

How it runs

When we run the program, it shows the menu.

If we press 1, it asks for student details and stores them.

If we press 2, it shows all students saved so far.

If we press 3, the program ends.
In this program I used ArrayList to store multiple students instead of a normal array.

Why ArrayList?

Array has a fixed size (example: if we make Student[50], we can store only 50 students).

ArrayList is dynamic, so we don’t need to decide size in advance. We can keep adding as many students as needed.
