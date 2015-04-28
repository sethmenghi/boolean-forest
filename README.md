#Project 4:

##The Boolean Forest
####Instructor: Lisa Singh (COSC 150)

####Collaborators - (netid) :      
* Julia Hockett - jlh279
* Leslie Kim  - lk584
* Megan Martin - mtm96
* Seth Menghi - swm36
* Marcus Stromeyer - mls267


##Honor Statement
 In accordance with the class policies and Georgetown's Honor Code,
 we certify that, with the exceptions of the lecture notes and those
 items noted below, we have neither given nor received any assistance
 on this project.


##Description

 This interactive applet is intended to be a teaching tool for first
 to third graders which aid in educating children the basics of Boolean
 logic in an interactive, fun and self-explanatory way.
 
 When the applet is started, the student is greeted by a family of owls.
 An Owl named Bob will interact with the student. The student needs to
 help the children owls get through the Boolean Logic Forest by learning
 the Boolean concepts explained by Bob and playing the levels to pass
 the level. The student will be asked 3 - 5 questions and will be able
 to select an answer choice until the correct answer is selected.
 
 A card layout is used to switch between layouts. The initial layout is
 an introduction screen (IntroPanel). There is a layout that contains the
 level map where the student passes each level to get through the Boolean
 Logic Forest (ForestPanel). There is also a layout that will display the
 questions for each level (QuestionPanel). The final layout is for the
 teacher/parent's page which explains the applet to the teacher/parent
 (TeachersPanel).
 
 Once the student helps the children owls pass Level 5, a certificate of
 completion will be displayed.
 

##Objectives

1. The applet is fun/interactive
2. Increases awareness for computer science
3. Kids should be able to go through this game with minimal or no help
    from a teacher/parent
    

##Project Organization

 The organization of this project is that the Game class of the
 BooleanForest package is the "controller" of the game. The overall level
 of the game is handled here, which will keep the ForestPanel updated.
 The Levels packages includes Level classes, which essentially declares
 the content for each level of the game. The Objects package contain
 classes that are objects used throughout the game. The Panels package
 contains different Panels that make up the CardLayout in the Game class.
 Panel is an interface which is implemented by each type of panel. The
 Questions package contains a Question interface which is implemented
 by each of the two Question types.
 
 The sources of any images used or URLs for code sources are listed at the
 top of each class file they are used in.


####Internet usage: 
Included is a html and jnlp file that run in firefox on Julie's computer. 
