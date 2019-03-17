-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tog
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tog
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tog` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `tog` ;

-- -----------------------------------------------------
-- Table `tog`.`cargotype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tog`.`cargotype` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tog`.`stations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tog`.`stations` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tog`.`weighttype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tog`.`weighttype` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tog`.`wagons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tog`.`wagons` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT,
  `StationsId` INT(10) NOT NULL,
  `WeightTypeId` INT(10) NOT NULL,
  `CargoTypeId` INT(10) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `FKWagons521129` (`StationsId` ASC) VISIBLE,
  INDEX `FKWagons882808` (`WeightTypeId` ASC) VISIBLE,
  INDEX `FKWagons262096` (`CargoTypeId` ASC) VISIBLE,
  CONSTRAINT `FKWagons262096`
    FOREIGN KEY (`CargoTypeId`)
    REFERENCES `tog`.`cargotype` (`Id`),
  CONSTRAINT `FKWagons521129`
    FOREIGN KEY (`StationsId`)
    REFERENCES `tog`.`stations` (`Id`),
  CONSTRAINT `FKWagons882808`
    FOREIGN KEY (`WeightTypeId`)
    REFERENCES `tog`.`weighttype` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tog`.`wagonstatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tog`.`wagonstatus` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tog`.`log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tog`.`log` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT,
  `Timestamp` TIMESTAMP NOT NULL,
  `WagonsId` INT(10) NOT NULL,
  `WagonStatusId` INT(10) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `FKLog502574` (`WagonsId` ASC) VISIBLE,
  INDEX `FKLog981203` (`WagonStatusId` ASC) VISIBLE,
  CONSTRAINT `FKLog502574`
    FOREIGN KEY (`WagonsId`)
    REFERENCES `tog`.`wagons` (`Id`),
  CONSTRAINT `FKLog981203`
    FOREIGN KEY (`WagonStatusId`)
    REFERENCES `tog`.`wagonstatus` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tog`.`routes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tog`.`routes` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT,
  `StationsId` INT(10) NOT NULL,
  `StopId` INT(10) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `FKRoutes726138` (`StationsId` ASC) VISIBLE,
  CONSTRAINT `FKRoutes726138`
    FOREIGN KEY (`StationsId`)
    REFERENCES `tog`.`stations` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
