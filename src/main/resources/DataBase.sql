CREATE SCHEMA IF NOT EXISTS `oleshchuk_db` DEFAULT CHARACTER SET utf8;
USE `oleshchuk_db`;

DROP TABLE IF EXISTS `oleshchuk_db`.`statement`;
DROP TABLE IF EXISTS `oleshchuk_db`.`Initiating_employee`;
DROP TABLE IF EXISTS `oleshchuk_db`.`responsible_employee`;
DROP TABLE IF EXISTS `oleshchuk_db`.`employee`;
DROP TABLE IF EXISTS `oleshchuk_db`.`equipment_location`;
DROP TABLE IF EXISTS `oleshchuk_db`.`status`;
DROP TABLE IF EXISTS `oleshchuk_db`.`priority`;
DROP TABLE IF EXISTS `oleshchuk_db`.`type_of_statement`;
DROP TABLE IF EXISTS `oleshchuk_db`.`working_position`;

CREATE TABLE IF NOT EXISTS `oleshchuk_db`.`working_position`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `oleshchuk_db`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oleshchuk_db`.`employee`
(
    `id`                  INT         NOT NULL AUTO_INCREMENT,
    `name`                VARCHAR(45) NULL,
    `surname`             VARCHAR(45) NOT NULL,
    `working_position_id` INT         NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_employee_working_position1_idx` (`working_position_id` ASC) VISIBLE,
    CONSTRAINT `fk_employee_working_position1`
        FOREIGN KEY (`working_position_id`)
            REFERENCES `oleshchuk_db`.`working_position` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `oleshchuk_db`.`Initiating_employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oleshchuk_db`.`Initiating_employee`
(
    `id`          INT NOT NULL AUTO_INCREMENT,
    `employee_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_Initiating_employee_employee1_idx` (`employee_id` ASC) VISIBLE,
    CONSTRAINT `fk_Initiating_employee_employee1`
        FOREIGN KEY (`employee_id`)
            REFERENCES `oleshchuk_db`.`employee` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `oleshchuk_db`.`equipment_location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oleshchuk_db`.`equipment_location`
(
    `id`                   INT         NOT NULL AUTO_INCREMENT,
    `office`               VARCHAR(45) NOT NULL,
    `room_number`          INT         NOT NULL,
    `working_place_number` INT         NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `oleshchuk_db`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oleshchuk_db`.`status`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `oleshchuk_db`.`priority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oleshchuk_db`.`priority`
(
    `id`    INT         NOT NULL AUTO_INCREMENT,
    `level` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `level_UNIQUE` (`level` ASC) VISIBLE
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `oleshchuk_db`.`responsible_employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oleshchuk_db`.`responsible_employee`
(
    `id`          INT NOT NULL AUTO_INCREMENT,
    `employee_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_responsible_employee_employee1_idx` (`employee_id` ASC) VISIBLE,
    CONSTRAINT `fk_responsible_employee_employee1`
        FOREIGN KEY (`employee_id`)
            REFERENCES `oleshchuk_db`.`employee` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `oleshchuk_db`.`type_of_statement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oleshchuk_db`.`type_of_statement`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `oleshchuk_db`.`statement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oleshchuk_db`.`statement`
(
    `id`                      INT         NOT NULL AUTO_INCREMENT,
    `description`             VARCHAR(45) NULL,
    `creation_date`           DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `initiating_employee_id`  INT         NOT NULL,
    `equipment_location_id`   INT         NOT NULL,
    `status_id`               INT         NOT NULL,
    `priority_id`             INT         NOT NULL,
    `responsible_employee_id` INT         NOT NULL,
    `type_of_statement_id`    INT         NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_statement_employee_idx` (`initiating_employee_id` ASC) VISIBLE,
    INDEX `fk_statement_equipment_location1_idx` (`equipment_location_id` ASC) VISIBLE,
    INDEX `fk_statement_status1_idx` (`status_id` ASC) VISIBLE,
    INDEX `fk_statement_priority1_idx` (`priority_id` ASC) VISIBLE,
    INDEX `fk_statement_responsible_employee1_idx` (`responsible_employee_id` ASC) VISIBLE,
    INDEX `fk_statement_type_of_statement1_idx` (`type_of_statement_id` ASC) VISIBLE,
    CONSTRAINT `fk_statement_employee`
        FOREIGN KEY (`initiating_employee_id`)
            REFERENCES `oleshchuk_db`.`Initiating_employee` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `fk_statement_equipment_location1`
        FOREIGN KEY (`equipment_location_id`)
            REFERENCES `oleshchuk_db`.`equipment_location` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `fk_statement_status1`
        FOREIGN KEY (`status_id`)
            REFERENCES `oleshchuk_db`.`status` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_statement_priority1`
        FOREIGN KEY (`priority_id`)
            REFERENCES `oleshchuk_db`.`priority` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_statement_responsible_employee1`
        FOREIGN KEY (`responsible_employee_id`)
            REFERENCES `oleshchuk_db`.`responsible_employee` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_statement_type_of_statement1`
        FOREIGN KEY (`type_of_statement_id`)
            REFERENCES `oleshchuk_db`.`type_of_statement` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

CREATE INDEX employee_name_idx ON employee (name);
CREATE INDEX employee_surname_idx ON employee (surname);

INSERT INTO `oleshchuk_db`.`status` (`name`)
VALUES ('new'),
       ('in proccess'),
       ('done');

INSERT INTO `oleshchuk_db`.`priority` (`level`)
VALUES ('low'),
       ('medium'),
       ('high');

INSERT INTO `oleshchuk_db`.`equipment_location` (`office`, `room_number`, `working_place_number`)
VALUES ('Lviv1', '101', '1'),
       ('Lviv2', '202', '2'),
       ('Lviv3', '303', '3'),
       ('Lviv4', '404', '4'),
       ('Lviv5', '505', '5'),
       ('Lviv6', '606', '6'),
       ('Lviv7', '707', '7'),
       ('Lviv8', '808', '8'),
       ('Lviv9', '909', '9'),
       ('HQ', '404', '4');

INSERT INTO `oleshchuk_db`.`working_position` (`name`)
VALUES ('QA'),
       ('SE'),
       ('HR'),
       ('PM'),
       ('DevOps'),
       ('Team Lead'),
       ('QC'),
       ('CEO'),
       ('Architect'),
       ('Data Scientist');

INSERT INTO `oleshchuk_db`.`type_of_statement` (`name`)
VALUES ('non-working equipment'),
       ('issuance of new equipment'),
       ('equipment replacement'),
       ('software update'),
       ('problems with software');

INSERT INTO `oleshchuk_db`.`employee` (`name`, `surname`, `working_position_id`)
VALUES ('Denis', 'Dudik', '1'),
       ('Andriy', 'Butynets', '2'),
       ('Danylo', 'Savchuk', '3'),
       ('Artur', 'Romaniuk', '4'),
       ('Kirill', 'Matviychuk', '5'),
       ('Stepan', 'Viytuk', '6'),
       ('Anatoliy', 'Matisheiko', '7'),
       ('Maksym', 'Shpak', '8'),
       ('Orest', 'Herasymchuk', '9'),
       ('Taras', 'Lisoviy', '10'),
       ('Sofia', 'Demiankova', '1'),
       ('Yana', 'Lavreniuk', '2'),
       ('Dasha', 'Romanovska', '3'),
       ('Karina', 'Protsiuk', '1'),
       ('Alisa', 'Popko', '3'),
       ('Katia', 'Tkachuk', '2'),
       ('Inna', 'Salabay', '2'),
       ('Liza', 'Klofa', '3'),
       ('Nastya', 'Shumik', '1'),
       ('Vika', 'Lebedeva', '3');

INSERT INTO `oleshchuk_db`.`responsible_employee` (`employee_id`)
VALUES ('1'),
       ('2'),
       ('3'),
       ('4'),
       ('5'),
       ('6'),
       ('7'),
       ('8'),
       ('9'),
       ('10');

INSERT INTO `oleshchuk_db`.`Initiating_employee` (`employee_id`)
VALUES ('11'),
       ('12'),
       ('13'),
       ('14'),
       ('15'),
       ('16'),
       ('17'),
       ('18'),
       ('19'),
       ('20');

INSERT INTO `oleshchuk_db`.`statement` (`description`, `initiating_employee_id`, `equipment_location_id`, `status_id`,
                                        `priority_id`, `responsible_employee_id`, `type_of_statement_id`)
VALUES ('desc1', '1', '1', '1', '1', '1', '1'),
       ('desc2', '2', '2', '2', '2', '2', '2'),
       ('desc3', '3', '3', '3', '3', '3', '3'),
       ('desc4', '4', '4', '1', '2', '4', '4'),
       ('desc5', '5', '5', '2', '1', '5', '1'),
       ('desc6', '6', '6', '3', '2', '6', '2'),
       ('desc7', '7', '7', '1', '3', '7', '1'),
       ('desc8', '8', '8', '2', '1', '8', '2'),
       ('desc9', '9', '9', '1', '1', '9', '3'),
       ('desc10', '10', '10', '1', '3', '10', '1');

