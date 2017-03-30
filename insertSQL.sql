INSERT INTO `adresse` (`adr_id`, `adr_voirie`, `adr_cp`, `adr_ville`) VALUES ('1', '2 Boulevard des capucins', '29200', 'Brest');
INSERT INTO `adresse` (`adr_id`, `adr_voirie`, `adr_cp`, `adr_ville`) VALUES ('2', '84 Rue de la belle foret', '29200', 'Brest');
INSERT INTO `adresse` (`adr_id`, `adr_voirie`, `adr_cp`, `adr_ville`) VALUES ('3', '6 bis Rue laFayette', '29000', 'Quimper');
INSERT INTO `adresse` (`adr_id`, `adr_voirie`, `adr_cp`, `adr_ville`) VALUES ('4', '20 Ruelle rouge', '29200', 'Quimper');
INSERT INTO `adresse` (`adr_id`, `adr_voirie`, `adr_cp`, `adr_ville`) VALUES ('5', '123 Rue Soleil', '29200', 'Brest');
INSERT INTO `adresse` (`adr_id`, `adr_voirie`, `adr_cp`, `adr_ville`) VALUES ('6', '86 Avenue Jeanne Arc', '29200', 'Brest');

INSERT INTO `utilisateur` (`util_id`, `util_nom`, `util_prenom`, `util_pass`, `util_tel`, `util_mail`, `util_adr`) VALUES ('1', 'Capé', 'Andy', 'azerty', '0649658265', 'andy.cape@gmail.com', '1');
INSERT INTO `utilisateur` (`util_id`, `util_nom`, `util_prenom`, `util_pass`, `util_tel`, `util_mail`, `util_adr`) VALUES ('2', 'Honette', 'Camille', 'azerty', '0632541298', 'camille.honette@gmail.com', '2');
INSERT INTO `utilisateur` (`util_id`, `util_nom`, `util_prenom`, `util_pass`, `util_tel`, `util_mail`, `util_adr`) VALUES ('3', 'Can', 'Jerry', 'azerty', '0666985542', 'jerry.can@gmail.com', '3');
INSERT INTO `utilisateur` (`util_id`, `util_nom`, `util_prenom`, `util_pass`, `util_tel`, `util_mail`, `util_adr`) VALUES ('4', 'Golay', 'Hilary', 'azerty', '0654956652', 'hilary.golay@gmail.com', '4');
INSERT INTO `utilisateur` (`util_id`, `util_nom`, `util_prenom`, `util_pass`, `util_tel`, `util_mail`, `util_adr`) VALUES ('5', 'Géfroi', 'Sandra', 'azerty', '0603265900', 'sandra.gefroi@gmail.com', '5');

INSERT INTO `commande` (`com_id`, `com_date_validation`, `com_date_livraison`, `com_util`, `com_adr`) VALUES ('1', '2017-02-03 00:00:00', '2017-02-04 00:00:00', '1', '1');
INSERT INTO `commande` (`com_id`, `com_date_validation`, `com_date_livraison`, `com_util`, `com_adr`) VALUES ('2', '2017-02-03 00:00:00', '2017-02-04 00:00:00', '2', '2');
INSERT INTO `commande` (`com_id`, `com_date_validation`, `com_date_livraison`, `com_util`, `com_adr`) VALUES ('3', '2017-02-03 00:00:00', '2017-02-04 00:00:00', '3', '6');
INSERT INTO `commande` (`com_id`, `com_date_validation`, `com_date_livraison`, `com_util`, `com_adr`) VALUES ('4', '2017-02-03 00:00:00', '2017-02-04 00:00:00', '1', '1');

INSERT INTO `mode` (`mode_id`, `mode_nom`) VALUES ('1', 'Comptant');
INSERT INTO `mode` (`mode_id`, `mode_nom`) VALUES ('2', 'Cheque');
INSERT INTO `mode` (`mode_id`, `mode_nom`) VALUES ('3', 'Carte Bancaire');

INSERT INTO `paiement` (`paie_id`, `paie_montant`, `paie_date`, `paie_com`, `paie_mode`) VALUES ('1', '20.00', '2017-02-03 00:00:00', '1', '2');
INSERT INTO `paiement` (`paie_id`, `paie_montant`, `paie_date`, `paie_com`, `paie_mode`) VALUES ('2', '20.00', '2017-02-03 00:00:00', '2', '2');
INSERT INTO `paiement` (`paie_id`, `paie_montant`, `paie_date`, `paie_com`, `paie_mode`) VALUES ('3', '20.00', '2017-02-03 00:00:00', '2', '1');
INSERT INTO `paiement` (`paie_id`, `paie_montant`, `paie_date`, `paie_com`, `paie_mode`) VALUES ('4', '20.00', '2017-02-03 00:00:00', '3', '3');
INSERT INTO `paiement` (`paie_id`, `paie_montant`, `paie_date`, `paie_com`, `paie_mode`) VALUES ('5', '20.00', '2017-02-03 00:00:00', '4', '3');

INSERT INTO `categorie` (`cat_id`, `cat_nom`) VALUES ('1', 'Entrée');
INSERT INTO `categorie` (`cat_id`, `cat_nom`) VALUES ('2', 'Viande');
INSERT INTO `categorie` (`cat_id`, `cat_nom`) VALUES ('3', 'Poisson');
INSERT INTO `categorie` (`cat_id`, `cat_nom`) VALUES ('4', 'Dessert');
INSERT INTO `categorie` (`cat_id`, `cat_nom`) VALUES ('5', 'Entrée Chaude');

INSERT INTO `plat` (`plat_id`,`plat_nom`, `plat_cat`, `plat_path`) VALUES ('1', 'Boeuf Bourgignon', '2', 'http://www.cuisine-astuce.com/wp-content/uploads/2013/02/Boeuf-Bourguignon-sans-alcool-recette-cuisine-halal.jpg');
INSERT INTO `plat` (`plat_id`,`plat_nom`, `plat_cat`, `plat_path`) VALUES ('2', 'Salade de Riz', '1','https://www.avocadocentral.com/sites/default/files/styles/banner/public/Avocado-Mango-Rice-Salad.jpg');
INSERT INTO `plat` (`plat_id`,`plat_nom`, `plat_cat`, `plat_path`) VALUES ('3', 'Paella', '2', 'http://assets.epicurious.com/photos/5764583142e4a5ed66d1df6c/2:1/w_1260%2Ch_630/seafood-paella.jpg');
INSERT INTO `plat` (`plat_id`,`plat_nom`, `plat_cat`, `plat_path`) VALUES ('4', 'Soupe à la Tomate', '5','http://cdn2.stylecraze.com/wp-content/uploads/2014/04/10-Amazing-Health-Benefits-Uses-Of-Tomato-Soup.jpg');
INSERT INTO `plat` (`plat_id`,`plat_nom`, `plat_cat`, `plat_path`) VALUES ('5', 'Panacotta', '4','http://assets.epicurious.com/photos/5761d0268accf290434553aa/master/pass/panna-cotta.jpg');
INSERT INTO `plat` (`plat_id`,`plat_nom`, `plat_cat`, `plat_path`) VALUES ('6', 'Kouign Amann', '4','http://media.meltyfood.fr/article-2775754-fb/le-kouign-amann-a-new-york.jpg');
INSERT INTO `plat` (`plat_id`,`plat_nom`, `plat_cat`, `plat_path`) VALUES ('7', 'Oeufs Mimosa', '1','http://www.maxi-mag.fr/sites/default/files/styles/lightbox_images_800x600/public/media/recipe/2014-06/oeuf-mimosa-crevettes.jpg');

INSERT INTO `ingredient` (`ing_id`, `ing_nom`) VALUES ('1', 'Boeuf');
INSERT INTO `ingredient` (`ing_id`, `ing_nom`) VALUES ('2', 'Salade');
INSERT INTO `ingredient` (`ing_id`, `ing_nom`) VALUES ('3', 'Tomate');
INSERT INTO `ingredient` (`ing_id`, `ing_nom`) VALUES ('4', 'Oignon');
INSERT INTO `ingredient` (`ing_id`, `ing_nom`) VALUES ('5', 'Riz');

INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('1', '1', '250', '15.00');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('1', '2', '10', '0.25');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('1', '4', '5', '0.10');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('1', '3', '10', '0.50');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('2', '2', '10', '0.50');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('2', '5', '150', '15.0');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('2', '3', '10', '0.50');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('3', '5', '150', '15.50');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('3', '1', '10', '0.50');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('3', '4', '10', '0.50');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('3', '2', '10', '0.50');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('4', '3', '100', '13.00');
INSERT INTO `l_ing_plat` (`lingplat_plat`, `lingplat_ing`, `ing_portion`, `ing_montant`) VALUES ('4', '4', '15', '2.00');

INSERT INTO `l_com_plat` (`lcomplat_com`, `lcomplat_plat`,`lcomplat_quantite`) VALUES ('1', '1', '2');
INSERT INTO `l_com_plat` (`lcomplat_com`, `lcomplat_plat`,`lcomplat_quantite`) VALUES ('1', '2', '1');
INSERT INTO `l_com_plat` (`lcomplat_com`, `lcomplat_plat`,`lcomplat_quantite`) VALUES ('2', '3', '3');
INSERT INTO `l_com_plat` (`lcomplat_com`, `lcomplat_plat`,`lcomplat_quantite`) VALUES ('3', '2', '2');
INSERT INTO `l_com_plat` (`lcomplat_com`, `lcomplat_plat`,`lcomplat_quantite`) VALUES ('3', '4', '1');
INSERT INTO `l_com_plat` (`lcomplat_com`, `lcomplat_plat`,`lcomplat_quantite`) VALUES ('4', '1', '1');
