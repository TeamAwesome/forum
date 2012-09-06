CREATE  TABLE `forum`.`USER_KNOWLEDGE` (
  `ID` INT NOT NULL ,
  `USER_ID` INT NOT NULL ,
  `KNOWLEDGE_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `USER_KNOWLEDGE_USER_ID_FK_idx` (`USER_ID` ASC) ,
  CONSTRAINT `USER_KNOWLEDGE_USER_ID_FK`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `forum`.`USER` (`ID` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);



--//@UNDO

drop table `forum`.`USER_KNOWLEDGE`;