CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tbFormaPagamento` (
  `idFormaPagamento` INT NOT NULL,
  `Descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idFormaPagamento`));

CREATE TABLE IF NOT EXISTS `mydb`.`tbContrato` (
    `idContrato` INT NOT NULL,
    `DataEmissao` DATE NOT NULL,
    `TempoVigencia` INT NOT NULL,
    `idFormaPagamento` INT NOT NULL,
    PRIMARY KEY (`idContrato`),
    FOREIGN KEY (`idFormaPagamento`)
        REFERENCES `mydb`.`tbFormaPagamento` (`idFormaPagamento`)
);

CREATE TABLE IF NOT EXISTS `mydb`.`tbUnidadeMedida` (
  `idUnidadeMedida` INT NOT NULL,
  `Descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idUnidadeMedida`));

CREATE TABLE IF NOT EXISTS `mydb`.`tbProduto` (
  `idProduto` INT NOT NULL,
  `Nome` VARCHAR(255) NOT NULL,
  `Descricao` VARCHAR(255) NOT NULL,
  `ValorUnitario` FLOAT NOT NULL,
  `idUnidadeMedida` INT NOT NULL,
  PRIMARY KEY (`idProduto`),
    FOREIGN KEY (`idUnidadeMedida`)
    REFERENCES `mydb`.`tbUnidadeMedida` (`idUnidadeMedida`));

CREATE TABLE IF NOT EXISTS `mydb`.`tbContrato_has_tbProduto` (
  `idContrato` INT NOT NULL,
  `idProduto` INT NOT NULL,
  `Quantidade` INT NOT NULL,
  PRIMARY KEY (`idContrato`, `idProduto`),
    FOREIGN KEY (`idContrato`)
    REFERENCES `mydb`.`tbContrato` (`idContrato`),
    FOREIGN KEY (`idProduto`)
    REFERENCES `mydb`.`tbProduto` (`idProduto`));

