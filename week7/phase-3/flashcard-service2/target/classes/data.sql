INSERT INTO TOPIC VALUES (1, 'Java'), (2, 'SQL');

INSERT INTO FLASHCARD (id, question, answer, name, difficulty, topic_id) VALUES
(
	1,
	'What is the root interface of the Collections API?',
	'Iterable is at the top of the Collection Heirarchy, but many consider the Collection interface to be the root.',
	'Collections Root Interface',
	1,
	1
);

INSERT INTO FLASHCARD (id, question, answer, name, difficulty, topic_id) VALUES
(
	2,
	'What are the 5 SQL Sublanguages?',
	'Data Definition Language, Data Manipulation Language, Data Query Language, Data Control Language, and Transaction Control Language.',
	'SQL Sublanguages',
	1,
	2
);

INSERT INTO QUIZ (id, grade, name) VALUES
(
	1,
	100,
	'Basic Quiz'
);

INSERT INTO QUIZ_CARDS (quiz_id, cards_id) VALUES (1, 1), (1, 2);