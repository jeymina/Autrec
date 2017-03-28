SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `adresse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adresse` (
  `adr_id` INT(11) NOT NULL AUTO_INCREMENT,
  `adr_voirie` VARCHAR(255) NULL,
  `adr_cp` VARCHAR(5) NULL,
  `adr_ville` VARCHAR(100) NULL,
  PRIMARY KEY (`adr_id`));


-- -----------------------------------------------------
-- Table `utilisateur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `util_id` INT(11) NOT NULL AUTO_INCREMENT,
  `util_nom` VARCHAR(50) NOT NULL,
  `util_prenom` VARCHAR(50) NOT NULL,
  `util_pass` VARCHAR(50) NOT NULL,
  `util_tel` VARCHAR(10) NOT NULL,
  `util_adr` INT(11) NOT NULL,
  `util_mail` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`util_id`),
  INDEX `fk_util_adr_idx` (`util_adr` ASC),
  UNIQUE INDEX `util_mail_UNIQUE` (`util_mail` ASC),
  CONSTRAINT `fk_util_adr`
    FOREIGN KEY (`util_adr`)
    REFERENCES `adresse` (`adr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `commande`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `commande` (
  `com_id` INT(11) NOT NULL AUTO_INCREMENT,
  `com_date_validation` TIMESTAMP NULL,
  `com_date_livraison` TIMESTAMP NULL,
  `com_util` INT(11) NOT NULL,
  `com_adr` INT(11) NULL,
  PRIMARY KEY (`com_id`),
  INDEX `fk_com_util_idx` (`com_util` ASC),
  INDEX `fk_com_adr_idx` (`com_adr` ASC),
  CONSTRAINT `fk_com_util`
    FOREIGN KEY (`com_util`)
    REFERENCES `utilisateur` (`util_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_com_adr`
    FOREIGN KEY (`com_adr`)
    REFERENCES `adresse` (`adr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mode` (
  `mode_id` INT(11) NOT NULL AUTO_INCREMENT,
  `mode_nom` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`mode_id`));


-- -----------------------------------------------------
-- Table `paiement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `paiement` (
  `paie_id` INT(11) NOT NULL AUTO_INCREMENT,
  `paie_montant` DECIMAL(10,2) NOT NULL,
  `paie_date` TIMESTAMP NOT NULL,
  `paie_com` INT(11) NOT NULL,
  `paie_mode` INT(11) NOT NULL,
  PRIMARY KEY (`paie_id`),
  INDEX `fk_paie_mode_idx` (`paie_mode` ASC),
  INDEX `fk_paie_com_idx` (`paie_com` ASC),
  CONSTRAINT `fk_paie_mode`
    FOREIGN KEY (`paie_mode`)
    REFERENCES `mode` (`mode_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_paie_com`
    FOREIGN KEY (`paie_com`)
    REFERENCES `commande` (`com_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `categorie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `categorie` (
  `cat_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cat_nom` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`cat_id`));


-- -----------------------------------------------------
-- Table `plat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `plat` (
  `plat_id` INT(11) NOT NULL AUTO_INCREMENT,
  `plat_nom` VARCHAR(50) NOT NULL,
  `plat_cat` INT(11) NOT NULL,
  PRIMARY KEY (`plat_id`),
  INDEX `fk_plat_cat_idx` (`plat_cat` ASC),
  CONSTRAINT `fk_plat_cat`
    FOREIGN KEY (`plat_cat`)
    REFERENCES `categorie` (`cat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `supplement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supplement` (
  `sup_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sup_nom` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`sup_id`));


-- -----------------------------------------------------
-- Table `ingredient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingredient` (
  `ing_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ing_nom` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ing_id`));


-- -----------------------------------------------------
-- Table `l_ing_plat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `l_ing_plat` (
  `lingplat_plat` INT(11) NOT NULL AUTO_INCREMENT,
  `lingplat_ing` INT(11) NOT NULL,
  `ing_portion` INT(11) NOT NULL,
  `ing_montant` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`lingplat_plat`, `lingplat_ing`),
  INDEX `fk_l_ing_idx` (`lingplat_ing` ASC),
  CONSTRAINT `fk_lingplat_plat`
    FOREIGN KEY (`lingplat_plat`)
    REFERENCES `plat` (`plat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lingplat_ing`
    FOREIGN KEY (`lingplat_ing`)
    REFERENCES `ingredient` (`ing_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `l_sup_plat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `l_sup_plat` (
  `lsupplat_plat` INT(11) NOT NULL AUTO_INCREMENT,
  `lsupplat_sup` INT(11) NOT NULL,
  PRIMARY KEY (`lsupplat_plat`, `lsupplat_sup`),
  INDEX `fk_loptplat_opt_idx` (`lsupplat_sup` ASC),
  CONSTRAINT `fk_loptplat_plat`
    FOREIGN KEY (`lsupplat_plat`)
    REFERENCES `plat` (`plat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lsupplat_sup`
    FOREIGN KEY (`lsupplat_sup`)
    REFERENCES `supplement` (`sup_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `l_com_plat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `l_com_plat` (
  `lcomplat_com` INT(11) NOT NULL AUTO_INCREMENT,
  `lcomplat_plat` INT(11) NOT NULL,
  `lcomplat_quantite` INT(11) NOT NULL,
  PRIMARY KEY (`lcomplat_com`, `lcomplat_plat`),
  INDEX `fk_lcomplat_plat_idx` (`lcomplat_plat` ASC),
  CONSTRAINT `fk_lcomplat_com`
    FOREIGN KEY (`lcomplat_com`)
    REFERENCES `commande` (`com_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lcomplat_plat`
    FOREIGN KEY (`lcomplat_plat`)
    REFERENCES `plat` (`plat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `l_complat_sup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `l_complat_sup` (
  `lcomplatsup_lcomplat_com` INT(11) NOT NULL,
  `lcomplatsup_lcomplat_plat` INT(11) NOT NULL,
  `lcomplatsup_sup` INT(11) NOT NULL,
  PRIMARY KEY (`lcomplatsup_lcomplat_com`, `lcomplatsup_sup`, `lcomplatsup_lcomplat_plat`),
  INDEX `fk_lcomplatsup_sup_idx` (`lcomplatsup_sup` ASC),
  INDEX `fk_lcomplatsup_complat_plat_idx` (`lcomplatsup_lcomplat_plat` ASC),
  CONSTRAINT `fk_lcomplatsup_sup`
    FOREIGN KEY (`lcomplatsup_sup`)
    REFERENCES `supplement` (`sup_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lcomplatsup_complat_plat`
    FOREIGN KEY (`lcomplatsup_lcomplat_plat`)
    REFERENCES `l_com_plat` (`lcomplat_plat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lcomplatsup_complat_com`
    FOREIGN KEY (`lcomplatsup_lcomplat_com`)
    REFERENCES `l_com_plat` (`lcomplat_com`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
