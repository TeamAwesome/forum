INSERT INTO QUESTION_TAG VALUES(1,2);
INSERT INTO QUESTION_TAG VALUES(2,1);
INSERT INTO QUESTION_TAG VALUES(3,2);
INSERT INTO QUESTION_TAG VALUES(4,4);
INSERT INTO QUESTION_TAG VALUES(5,10);
INSERT INTO QUESTION_TAG VALUES(6,7);


INSERT INTO TAG(NAME) VALUES('Blore');
INSERT INTO TAG(NAME) VALUES('Food');
INSERT INTO TAG(NAME) VALUES('Accommodation');
INSERT INTO TAG(NAME) VALUES('Spice');
INSERT INTO TAG(NAME) VALUES('Auto Rickshaw');
INSERT INTO TAG(NAME) VALUES('Music');
INSERT INTO TAG(NAME) VALUES('Out and about');
INSERT INTO TAG(NAME) VALUES('Shopping');
INSERT INTO TAG(NAME) VALUES('Fashion');
INSERT INTO TAG(NAME) VALUES('Motorcycles');


INSERT INTO CUSTOMERS(FIRST_NAME, LAST_NAME, AGE, ADDRESS, SALARY)
    VALUES('John', 'Corner', 20, '#45, Terminator Street, Hollywood, USA', 10000000.1);

INSERT INTO USER(USERNAME, PASSWORD, NAME, EMAIL_ADDRESS,PHONE_NUMBER, COUNTRY, GENDER, AGE_RANGE, PRIVACY, CREATED_AT, PRIVILEGE)
    VALUES('Jules', '5f4dcc3b5aa765d61d8327deb882cf99','Jules','Jules@thoughtworks.com','9982374762','INDIA','M', 2, 1, '2012-08-23 07:08:04', 1);

INSERT INTO USER(USERNAME, PASSWORD, NAME, EMAIL_ADDRESS,PHONE_NUMBER, COUNTRY, GENDER, AGE_RANGE, PRIVACY, CREATED_AT, PRIVILEGE)
    VALUES('lu', '5f4dcc3b5aa765d61d8327deb882cf99','Lu Liu','lu.lie@thoughtworks.com','9982374762','INDIA','F', 1, 1, '2012-08-23 07:08:04', 2);

INSERT INTO USER(USERNAME, PASSWORD, NAME, EMAIL_ADDRESS,PHONE_NUMBER, COUNTRY, GENDER, AGE_RANGE, PRIVACY, CREATED_AT, PRIVILEGE)
    VALUES('cece', '5f4dcc3b5aa765d61d8327deb882cf99','cece','cece@thoughtworks.com','9982374762','INDIA','F',1, 1, '2012-08-24 07:08:04', 3);

INSERT INTO USER(USERNAME, PASSWORD, NAME, EMAIL_ADDRESS,PHONE_NUMBER, COUNTRY, GENDER, AGE_RANGE, PRIVACY, CREATED_AT, PRIVILEGE)
    VALUES('tom', '5f4dcc3b5aa765d61d8327deb882cf99','tom','tom@thoughtworks.com','9982374762','INDIA','F',2, 0, '2012-08-25 09:08:04', 4);

INSERT INTO USER(USERNAME, PASSWORD, NAME, EMAIL_ADDRESS,PHONE_NUMBER, COUNTRY, GENDER, AGE_RANGE, PRIVACY, CREATED_AT, PRIVILEGE)
    VALUES('user4', '5f4dcc3b5aa765d61d8327deb882cf99','name d','exx@thoughtworks.com','9982374762','INDIA','F',4, 1, '2012-08-26 07:58:04', 4);

INSERT INTO USER(USERNAME, PASSWORD, NAME, EMAIL_ADDRESS,PHONE_NUMBER, COUNTRY, GENDER, AGE_RANGE, PRIVACY, CREATED_AT, PRIVILEGE)
    VALUES('user5', '5f4dcc3b5aa765d61d8327deb882cf99','AAAA','asfd@thoughtworks.com','9982374762','INDIA','F',3, 1, '2012-08-27 07:08:23', 4);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Shopping places in the city', 'I\'m looking for nice places to shop in Bangalore, can anyone make any suggestions?',
           '2012-08-23 07:08:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('How much should I be paying?', 'I\'m new to Bangalore, and I\'ve been taking auto-rickshaws to get around, but my local friends keep telling me I\'m being ripped off. So tell me, what\'s a decent price for a short journey.',
            '2012-08-23 08:08:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Where\'s the best place to eat in Koramangala?', 'I\'m only in India for a week, and I\'m staying near Koramangala, I don\'t have time to try all the food here though, so could anyone suggest a good place?' ,
            '2012-08-23 09:08:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('I can\'t take the spice', 'Someone please tell me where I can find non spicy food. ;_;', '2012-08-23 10:00:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Can anyone recommend a good map for exploring Bangalore with?', 'Please?', '2012-08-23 10:01:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Guys, I don\'t believe it', 'There was totally a cow in the road today, it caused such a massive traffic jam I couldn\'t even believe it!', '2012-08-23 10:02:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Why is it so cold?', 'I know it\'s monsoon season and everything, but I\'m like totally freezing. You know? Gosh, like, hand me a sweater already! Can I even buy a sweater in Bangalore, like, I dunno.' ,
            '2012-08-23 10:03:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Thinking of moving to Bangalore', 'Hi, I\'m currently living in the U.S. but My company recently offered me the opportunity to work in Bangalore for at least a year. I\'m seriously considering it, but I\'d like to get some advice from people who have possibly already been in a similar situation. Can anybody help?' ,
            '2012-08-23 10:04:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('What\'s up guys', 'How\'s life treating everyone?', '2012-08-23 10:05:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Does anyone know...', '...if the ice is made from drinking water here?', '2012-08-23 10:06:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Places to stay', 'Has anyone stayed in the Diamond District, is it a nice place? I\'m in Bangalore for 2 months so I want to be in a nice place.', '2012-08-23 10:07:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Which is more popular, Cricket or Hockey?', 'See Title', '2012-08-23 10:08:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Woo I\'m so excited to be here!' , 'What should I go see first! :D', '2012-08-23 10:09:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('I can\'t decide where to go', 'I\'ve heard commercial street is really great for shopping, but I\'ve heard about Brigade road too. Which one should I go to first?' ,
            '2012-08-23 10:10:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('What kind of music is popular in Bangalore', 'I really love going to music shows, and I\'m not picky about the kind of music I listen too. Can anyone recommend some acts I could see in the next month or so?', '2012-08-23 10:11:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Why are there signs all over Koramangala that say B-trac?', 'I want to know!', '2012-08-23 10:12:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Why does spicy ice cream exist?', 'why?', '2012-08-23 10:13:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('I\'m doing a pecha kucha on Bangalore for school'  , 'Can everyone tell me things about Bangalore?', '2012-08-23 10:14:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Is Bangalore worth visiting', 'I want to either visit Delhi or Bangalore, I only have a week to spend, so I can\'t visit both, but if you guys tell me it\'s good then I might postpone my trip until I can spend longer out there.' , '2012-08-23 10:15:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES("What's the local language in Bangalore", "I can't remember. D:", '2012-08-23 10:16:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES("How long to Pondicherry", "I live in Bangalore, and I want to explore India a bit, how long will it take me to drive from Bangalore to Pondicherry.", '2012-08-13 10:18:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES("What good Hindi movies are out?", "Also where's the nicest cinema in Bangalore to go an see them in?", '2012-08-13 10:19:04', 1);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES('Crossing the road is scary', "I don't understand! How do people cross roads here? D: ", '2012-08-25 10:19:54', 3);

INSERT INTO QUESTION(
    TITLE,
    DESCRIPTION,
    CREATED_AT,
    USER_ID)
  VALUES("What's the weather like in Bangalore currently? ", "I want to visit, but I hear it's been raining", '2012-08-13 10:20:04', 2);

INSERT INTO ADVICE(
    ID,
    DESCRIPTION,
    CREATED_AT,
    QUESTION_ID,
    USER_ID)
  VALUES(1, "I want to visit, but I hear it's been raining", '2012-08-13 10:20:04', 1,3);

