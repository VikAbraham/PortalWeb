INSERT INTO pelicula (titulo, anio, director, genero, sinopsis, duracion, imagen, create_at)
VALUES
  ('The Godfather', 1972, 'Francis Ford Coppola', 'Drama', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 175, 'https://chileposter.cl/wp-content/uploads/2023/11/EL-PADRINO-EDICION-ESPECIAL-.jpg', '1972-03-14'),

  ('The Shawshank Redemption', 1994, 'Frank Darabont', 'Drama', 'A mild-mannered banker is wrongly convicted of murdering his wife and ends up in prison, where he encounters a hardened criminal who will become his unlikely friend.', 142, 'https://image.tmdb.org/t/p/original/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg', '2023-11-07'),

  ('The Dark Knight', 2008, 'Christopher Nolan', 'Action, Crime, Thriller', 'With the help of Jim Gordon and a young district attorney, Batman must confront the enigmatic criminal mastermind known as the Joker who plunges Gotham City into anarchy.', 152, 'https://visualprint-store.com/cdn/shop/products/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw_._V1__1.jpg', '2023-11-07'),

  ('Pulp Fiction', 1994, 'Quentin Tarantino', 'Crime, Comedy', 'The lives of two mob hit men, a boxer, and a gangster wife intertwine in a series of violent events.', 154, 'https://chileposter.cl/wp-content/uploads/2023/11/pulp-fiction-689x1024.jpg', '2023-11-07'),

  ('Inception', 2010, 'Christopher Nolan', 'Action, Crime, Thriller, Sci-Fi', 'A professional thief who steals corporate secrets through use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.', 148, '//www.originalfilmart.com/cdn/shop/products/inception_2010_imax_original_film_art_5000x.jpg?v=1551890318', '2023-11-07');
 
 INSERT INTO resena (usuario, pelicula, puntuacion, comentario)
VALUES 
    ('Juan Pérez', 'El Padrino', 5.0, 'Una obra maestra'),
    ('Ana López', 'Pulp Fiction', 4.5, 'Muy original');
    
    INSERT INTO usuario (nombre, correo, fecha_nacimiento, pass)
VALUES
    ('Juan Pérez', 'juan@example.com', '1990-01-01', 'contraseña123'),
    ('Ana López', 'ana@example.com', '1985-05-15', 'password456');