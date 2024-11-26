INSERT INTO pelicula (titulo, anio, director, genero, sinopsis, duracion, imagen, create_at)
VALUES
  ('El Padrino', 1972, 'Francis Ford Coppola', 'Drama', 'El patriarca envejecido de una dinastía del crimen organizado transfiere el control de su imperio clandestino a su hijo reacio.', 175, 'https://chileposter.cl/wp-content/uploads/2023/11/EL-PADRINO-EDICION-ESPECIAL-.jpg', '1972-03-14'),

  ('Sueño de fuga', 1994, 'Frank Darabont', 'Drama', 'Un banquero de carácter apacible es condenado erróneamente por el asesinato de su esposa y termina en prisión, donde conoce a un criminal endurecido que se convertirá en su improbable amigo.', 142, 'https://image.tmdb.org/t/p/original/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg', '2023-11-07'),

  ('El caballero de la noche', 2008, 'Christopher Nolan', 'Acción, Crimen, Thriller', 'Con la ayuda de Jim Gordon y un joven fiscal del distrito, Batman debe enfrentar al enigmático criminal conocido como el Joker, quien sumerge a Gotham City en la anarquía.', 152, 'https://visualprint-store.com/cdn/shop/products/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw_._V1__1.jpg', '2023-11-07'),

  ('Pulp Fiction', 1994, 'Quentin Tarantino', 'Crimen, Comedia', 'Las vidas de dos asesinos a sueldo, un boxeador y la esposa de un gánster se entrelazan en una serie de eventos violentos.', 154, 'https://chileposter.cl/wp-content/uploads/2023/11/pulp-fiction-689x1024.jpg', '2023-11-07'),

  ('Origen', 2010, 'Christopher Nolan', 'Acción, Crimen, Thriller, Ciencia Ficción', 'Un ladrón profesional que roba secretos corporativos mediante el uso de tecnología de compartición de sueños recibe la tarea inversa de implantar una idea en la mente de un CEO.', 148, '//www.originalfilmart.com/cdn/shop/products/inception_2010_imax_original_film_art_5000x.jpg?v=1551890318', '2023-11-07');

INSERT INTO resena (usuario, pelicula, puntuacion, comentario)
VALUES 
    ('Juan Pérez', 'El Padrino', 5.0, 'Una obra maestra'),
    ('Ana López', 'Pulp Fiction', 4.5, 'Muy original');
    
INSERT INTO usuario (nombre, correo, fecha_nacimiento, pass)
VALUES
    ('Juan Pérez', 'juan@example.com', '1990-01-01', 'contraseña123'),
    ('Ana López', 'ana@example.com', '1985-05-15', 'password456');