CREATE TABLE IF NOT EXISTS `user` (
  `id`       BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(20) NOT NULL,
  `email`    VARCHAR(50) NOT NULL,
  `password` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_182xa1gitcxqhaq6nn3n2kmo3` (`email`)
)

  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;
