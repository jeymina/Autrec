SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `Adresse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Adresse` (
  `adr_id` INT(11) NOT NULL,
  `adr_voirie` VARCHAR(255) NULL,
  `adr_cp` VARCHAR(5) NULL,
  `adr_ville` VARCHAR(100) NULL,
  PRIMARY KEY (`adr_id`));


-- -----------------------------------------------------
-- Table `Utilisateur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Utilisateur` (
  `util_id` INT(11) NOT NULL,
  `util_nom` VARCHAR(50) NOT NULL,
  `util_prenom` VARCHAR(50) NOT NULL,
  `util_pass` VARCHAR(50) NOT NULL,
  `util_tel` VARCHAR(10) NOT NULL,
  `util_adr` INT(11) NOT NULL,
  PRIMARY KEY (`util_id`),
  INDEX `fk_util_adr_idx` (`util_adr` ASC),
  CONSTRAINT `fk_util_adr`
    FOREIGN KEY (`util_adr`)
    REFERENCES `Adresse` (`adr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Commande`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Commande` (
  `com_id` INT(11) NOT NULL,
  `com_date_validation` TIMESTAMP NULL,
  `com_date_livraison` TIMESTAMP NULL,
  `com_util` INT(11) NOT NULL,
  `com_adr` INT(11) NULL,
  PRIMARY KEY (`com_id`),
  INDEX `fk_com_util_idx` (`com_util` ASC),
  INDEX `fk_com_adr_idx` (`com_adr` ASC),
  CONSTRAINT `fk_com_util`
    FOREIGN KEY (`com_util`)
    REFERENCES `Utilisateur` (`util_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_com_adr`
    FOREIGN KEY (`com_adr`)
    REFERENCES `Adresse` (`adr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Mode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Mode` (
  `mode_id` INT(11) NOT NULL,
  `mode_nom` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`mode_id`));


-- -----------------------------------------------------
-- Table `Paiement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Paiement` (
  `paie_id` INT(11) NOT NULL,
  `paie_montant` DECIMAL(10,2) NOT NULL,
  `paie_date` TIMESTAMP NOT NULL,
  `paie_com` INT(11) NOT NULL,
  `paie_mode` INT(11) NOT NULL,
  PRIMARY KEY (`paie_id`),
  INDEX `fk_paie_mode_idx` (`paie_mode` ASC),
  INDEX `fk_paie_com_idx` (`paie_com` ASC),
  CONSTRAINT `fk_paie_mode`
    FOREIGN KEY (`paie_mode`)
    REFERENCES `Mode` (`mode_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_paie_com`
    FOREIGN KEY (`paie_com`)
    REFERENCES `Commande` (`com_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Categorie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Categorie` (
  `cat_id` INT(11) NOT NULL,
  `cat_nom` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`cat_id`));


-- -----------------------------------------------------
-- Table `Plat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Plat` (
  `plat_id` INT(11) NOT NULL,
  `plat_nom` VARCHAR(50) NOT NULL,
  `plat_cat` INT(11) NOT NULL,
  PRIMARY KEY (`plat_id`),
  INDEX `fk_plat_cat_idx` (`plat_cat` ASC),
  CONSTRAINT `fk_plat_cat`
    FOREIGN KEY (`plat_cat`)
    REFERENCES `Categorie` (`cat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Option` (
  `opt_id` INT(11) NOT NULL,
  `opt_nom` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`opt_id`));


-- -----------------------------------------------------
-- Table `Ingredient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Ingredient` (
  `ing_id` INT(11) NOT NULL,
  `ing_nom` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ing_id`));


-- -----------------------------------------------------
-- Table `l_ing_plat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `l_ing_plat` (
  `lingplat_plat` INT(11) NOT NULL,
  `lingplat_ing` INT(11) NOT NULL,
  `ing_portion` INT(11) NOT NULL,
  `ing_montant` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`lingplat_plat`, `lingplat_ing`),
  INDEX `fk_l_ing_idx` (`lingplat_ing` ASC),
  CONSTRAINT `fk_lingplat_plat`
    FOREIGN KEY (`lingplat_plat`)
    REFERENCES `Plat` (`plat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lingplat_ing`
    FOREIGN KEY (`lingplat_ing`)
    REFERENCES `Ingredient` (`ing_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `l_opt_plat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `l_opt_plat` (
  `loptplat_plat` INT(11) NOT NULL,
  `loptplat_opt` INT(11) NOT NULL,
  PRIMARY KEY (`loptplat_plat`, `loptplat_opt`),
  INDEX `fk_loptplat_opt_idx` (`loptplat_opt` ASC),
  CONSTRAINT `fk_loptplat_plat`
    FOREIGN KEY (`loptplat_plat`)
    REFERENCES `Plat` (`plat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_loptplat_opt`
    FOREIGN KEY (`loptplat_opt`)
    REFERENCES `Option` (`opt_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `l_com_plat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `l_com_plat` (
  `lcomplat_com` INT(11) NOT NULL,
  `lcomplat_plat` INT(11) NOT NULL,
  `lcomplat_quantite` INT(11) NOT NULL,
  PRIMARY KEY (`lcomplat_com`, `lcomplat_plat`),
  INDEX `fk_lcomplat_plat_idx` (`lcomplat_plat` ASC),
  CONSTRAINT `fk_lcomplat_com`
    FOREIGN KEY (`lcomplat_com`)
    REFERENCES `Commande` (`com_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lcomplat_plat`
    FOREIGN KEY (`lcomplat_plat`)
    REFERENCES `Plat` (`plat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
