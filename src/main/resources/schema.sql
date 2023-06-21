
create schema IF NOT EXISTS colapp;

use colapp;

/*
CREATE TABLE colapp.Usuarios (
`id` int(11) NOT NULL AUTO_INCREMENT,
`email` text,
`password` text,
`nombre` text,
PRIMARY KEY (`id`)
);

alter table colapp.usuarios add column password_hash text after password;

alter table colapp.usuarios add column rol text DEFAULT 'USUARIO';

CREATE TABLE colapp.Cervezas (
`id` int(11) NOT NULL AUTO_INCREMENT,
`nombre` varchar(50) DEFAULT NULL,
`imagen` text,
`alcohol` float DEFAULT NULL,
`color` varchar(50) DEFAULT NULL,
`categoria` text,
`descripcion` text,
PRIMARY KEY (`id`)
);


CREATE TABLE colapp.Notas (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `creado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 `titulo` text,
 `contenido` text,
 `publico` tinyint(1) DEFAULT NULL,
 `usuarioid` int(11) NOT NULL,
 `cervezaid` int(11) NOT NULL,
 PRIMARY KEY (`id`)
);


alter table colapp.Notas add foreign key (usuarioid) references colapp.usuarios(id);
alter table colapp.Notas add foreign key (cervezaid) references colapp.cervezas(id);

*/