INSERT INTO `adresse` (`adr_id`, `adr_voirie`, `adr_cp`, `adr_ville`) VALUES ('1', 'Boulevard des capucins', '29200', 'Brest');
INSERT INTO `adresse` (`adr_id`, `adr_voirie`, `adr_cp`, `adr_ville`) VALUES ('2', 'Ruelle rouge', '29200', 'Brest');

INSERT INTO `utilisateur` (`util_id`, `util_nom`, `util_prenom`, `util_pass`, `util_tel`, `util_adr`) VALUES ('1', 'toto', 'toto', 'azerty', '1234567890', '1');
INSERT INTO `utilisateur` (`util_id`, `util_nom`, `util_prenom`, `util_pass`, `util_tel`, `util_adr`) VALUES ('2', 'tata', 'tata', 'azerty', '1234567890', '1');
INSERT INTO `utilisateur` (`util_id`, `util_nom`, `util_prenom`, `util_pass`, `util_tel`, `util_adr`) VALUES ('3', 'tutu', 'tutu', 'azerty', '1234567890', '1');
INSERT INTO `utilisateur` (`util_id`, `util_nom`, `util_prenom`, `util_pass`, `util_tel`, `util_adr`) VALUES ('4', 'titi', 'titi', 'azerty', '1234567890', '1');
INSERT INTO `utilisateur` (`util_id`, `util_nom`, `util_prenom`, `util_pass`, `util_tel`, `util_adr`) VALUES ('5', 'tete', 'tete', 'azerty', '1234567890', '1');

INSERT INTO `categorie` (`cat_id`, `cat_nom`) VALUES ('1', 'Entrée');
INSERT INTO `categorie` (`cat_id`, `cat_nom`) VALUES ('2', 'Viande');
INSERT INTO `categorie` (`cat_id`, `cat_nom`) VALUES ('3', 'Poisson');
INSERT INTO `categorie` (`cat_id`, `cat_nom`) VALUES ('4', 'Dessert');
INSERT INTO `categorie` (`cat_id`, `cat_nom`) VALUES ('5', 'Entrée Chaude');

INSERT INTO `plat` (`plat_id`,`plat_nom`, `plat_cat`) VALUES ('1', 'Boeuf Bourgignon', '2');
INSERT INTO `plat` (`plat_id`,`plat_nom`, `plat_cat`) VALUES ('2', 'Salade de riz', '1');
INSERT INTO `plat` (`plat_id`,`plat_nom`, `plat_cat`) VALUES ('3', 'Paella', '2');
INSERT INTO `plat` (`plat_id`,`plat_nom`, `plat_cat`) VALUES ('4', 'Soupe', '5');

INSERT INTO `ingredient` (`ing_id`, `ing_nom`) VALUES ('1', 'viande');
INSERT INTO `ingredient` (`ing_id`, `ing_nom`) VALUES ('2', 'salade');
INSERT INTO `ingredient` (`ing_id`, `ing_nom`) VALUES ('3', 'tomate');
INSERT INTO `ingredient` (`ing_id`, `ing_nom`) VALUES ('4', 'oignon');

INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('1', '1', '250', '15.00');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('1', '3', '10', '0.50');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('4', '3', '100', '13.00');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('4', '4', '15', '2.00');


