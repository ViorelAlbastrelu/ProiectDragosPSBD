SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `Magazin` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `Magazin` ;

-- -----------------------------------------------------
-- Table `Magazin`.`Furnizor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Magazin`.`Furnizor` (
  `idf` INT NOT NULL ,
  `nume` VARCHAR(30) NOT NULL ,
  `adresa` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`idf`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Magazin`.`Producator`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Magazin`.`Producator` (
  `idp` INT NOT NULL ,
  `nume` VARCHAR(30) NOT NULL ,
  `adresa` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`idp`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Magazin`.`Piese`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Magazin`.`Piese` (
  `codp` INT NOT NULL ,
  `den` VARCHAR(45) NOT NULL ,
  `datafab` DATE NOT NULL ,
  `stoc` INT NOT NULL ,
  `pret` INT NOT NULL ,
  `Producator_idp` INT NOT NULL ,
  PRIMARY KEY (`codp`, `Producator_idp`) ,
  INDEX `fk_Piese_Producator1` (`Producator_idp` ASC) ,
  CONSTRAINT `fk_Piese_Producator1`
    FOREIGN KEY (`Producator_idp` )
    REFERENCES `Magazin`.`Producator` (`idp` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Magazin`.`Masina`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Magazin`.`Masina` (
  `codm` INT NOT NULL ,
  `marca` VARCHAR(20) NOT NULL ,
  `model` VARCHAR(20) NOT NULL ,
  `anfab` INT(4) NOT NULL ,
  `comb` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`codm`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Magazin`.`Client`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Magazin`.`Client` (
  `codc` INT NOT NULL ,
  `nume` VARCHAR(30) NOT NULL ,
  `pren` VARCHAR(30) NOT NULL ,
  `adr` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`codc`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Magazin`.`Promotie`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Magazin`.`Promotie` (
  `codprom` INT NOT NULL ,
  `discount` INT NOT NULL ,
  `datal` DATE NOT NULL ,
  `dataf` DATE NOT NULL ,
  `Piese_codp` INT NOT NULL ,
  PRIMARY KEY (`codprom`, `Piese_codp`) ,
  INDEX `fk_Promotie_Piese1` (`Piese_codp` ASC) ,
  CONSTRAINT `fk_Promotie_Piese1`
    FOREIGN KEY (`Piese_codp` )
    REFERENCES `Magazin`.`Piese` (`codp` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Magazin`.`Vanzare`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Magazin`.`Vanzare` (
  `codf` INT NOT NULL ,
  `datav` DATE NOT NULL ,
  `Client_codc` INT NOT NULL ,
  PRIMARY KEY (`codf`, `Client_codc`) ,
  INDEX `fk_Vanzare_Client1` (`Client_codc` ASC) ,
  CONSTRAINT `fk_Vanzare_Client1`
    FOREIGN KEY (`Client_codc` )
    REFERENCES `Magazin`.`Client` (`codc` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Magazin`.`FurnPiese`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Magazin`.`FurnPiese` (
  `Furnizor_idf` INT NOT NULL ,
  `Piese_codp` INT NOT NULL ,
  `garantie` INT NOT NULL ,
  PRIMARY KEY (`Furnizor_idf`, `Piese_codp`) ,
  INDEX `fk_Furnizor_has_Piese_Piese1` (`Piese_codp` ASC) ,
  INDEX `fk_Furnizor_has_Piese_Furnizor1` (`Furnizor_idf` ASC) ,
  CONSTRAINT `fk_Furnizor_has_Piese_Furnizor1`
    FOREIGN KEY (`Furnizor_idf` )
    REFERENCES `Magazin`.`Furnizor` (`idf` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Furnizor_has_Piese_Piese1`
    FOREIGN KEY (`Piese_codp` )
    REFERENCES `Magazin`.`Piese` (`codp` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Magazin`.`Factura`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Magazin`.`Factura` (
  `Piese_codp` INT NOT NULL ,
  `Vanzare_codf` INT NOT NULL ,
  `cant` INT NOT NULL ,
  PRIMARY KEY (`Piese_codp`, `Vanzare_codf`) ,
  INDEX `fk_Piese_has_Vanzare_Vanzare1` (`Vanzare_codf` ASC) ,
  INDEX `fk_Piese_has_Vanzare_Piese1` (`Piese_codp` ASC) ,
  CONSTRAINT `fk_Piese_has_Vanzare_Piese1`
    FOREIGN KEY (`Piese_codp` )
    REFERENCES `Magazin`.`Piese` (`codp` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Piese_has_Vanzare_Vanzare1`
    FOREIGN KEY (`Vanzare_codf` )
    REFERENCES `Magazin`.`Vanzare` (`codf` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Magazin`.`Compatibilitate`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Magazin`.`Compatibilitate` (
  `Piese_codp` INT NOT NULL ,
  `Masina_codm` INT NOT NULL ,
  PRIMARY KEY (`Piese_codp`, `Masina_codm`) ,
  INDEX `fk_Piese_has_Masina_Masina1` (`Masina_codm` ASC) ,
  INDEX `fk_Piese_has_Masina_Piese1` (`Piese_codp` ASC) ,
  CONSTRAINT `fk_Piese_has_Masina_Piese1`
    FOREIGN KEY (`Piese_codp` )
    REFERENCES `Magazin`.`Piese` (`codp` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Piese_has_Masina_Masina1`
    FOREIGN KEY (`Masina_codm` )
    REFERENCES `Magazin`.`Masina` (`codm` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
