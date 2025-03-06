# Hal9000 User Guide

// Product screenshot goes here

Hal9000 is a personal chatbot which will allow you to record your tasks in the form of todos, deadlines and events, and refer to them at a later time.

## Quick Start

1. Ensure you have Java 17 or above installed in your Computer.
Mac users: Ensure you have the precise JDK version prescribed here.

2. Download the latest .jar file

3. Copy the file to the folder you want to use as the home folder for Hal9000.

4. Open a command terminal, cd into the folder you put the jar file in, and use the java -jar Hal9000.jar command to run the application.

5. Type the command in the command box and press Enter to execute it. e.g. typing `list` and pressing Enter will show the list of all of your tasks.
Some example commands you can try:

  `todo TaskName` : Create a todo task with task name "TaskName"

  `delete 1` : Delete the first task in the list

  `bye` : Exits the application

6. Refer to the Features below for details of each command.

## Features

### Adding todo tasks: `todo`

Adds a todo task to the task list.

Format: `todo TASKNAME`

Example: `todo read book`
Adds a todo task called read book.


### Adding deadline tasks: `deadline`

Adds a deadline task to the task list.

Format: `deadline TASKNAME /by DEADLINE_BY_DATE`

Example: `deadline read book /by 06-03-2025`
Adds a deadline task called read book due on 06-03-2025


### Adding event tasks: `event`

Adds an event task to the task list.

Format: `event TASKNAME /from EVENT_FROM_DATE /to EVENT_TO_DATE`

Example: `event read book /from 06-03-2025 /to 06-03-2026`
Adds an event task called read book which lasts from 06-03-2025 to 06/03/2026


### Listing all tasks: `list`

Lists all of the tasks in the task list.

Format: `list`

Example: `list`
Lists all of the tasks.


### Marking tasks as done: `mark`

Marks a task as done from the task list using its index.

Format: `mark TASK_INDEX`

Example: `mark 3`
Marks the third task in the list as done.


### Unmarking tasks as done: `mark`

Unmarks a task as done from the task list using its index.

Format: `unmark TASK_INDEX`

Example: `unmark 3`
Unmarks the third task in the list as done.


### Deleting tasks: `delete`

Deletes a task from the task list using its index.

Format: `delete TASK_INDEX`

Example: `delete 3`
Deletes the third task in the list.


### Finding tasks: `find`

Finds tasks from the task list using keywords.

Format: `find KEYWORD`

Example: `find read`
Finds and lists all tasks with keyword "read".


### Exiting the program: `bye`

Exits the program.

Format: `bye`


### Saving the data

Tasks are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.


## Command Summary

| Action  | Format |
| ------------- | ------------- |
| Todo  | `todo TASKNAME`  |
| Deadline  | `deadline TASKNAME /by DEADLINE_BY_DATE`  |
| Event  | `event TASKNAME /from EVENT_FROM_DATE /to EVENT_TO_DATE`  |
| List  | `list`  |
| Mark  | `mark TASK_INDEX`  |
| Unmark  | `unmark TASK_INDEX`  |
| Delete  | `delete TASK_INDEX`  |
| Find  | `find KEYWORD`  |

