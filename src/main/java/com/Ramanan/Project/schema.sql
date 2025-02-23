-- Create the information table
CREATE TABLE information (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    visibility VARCHAR(50) NOT NULL
);

-- Create the access_requests table
CREATE TABLE access_requests (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    information_id BIGINT NOT NULL,
    status VARCHAR(50) NOT NULL,
    CONSTRAINT fk_access_requests_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_access_requests_information FOREIGN KEY (information_id) REFERENCES information (id) ON DELETE CASCADE
);


DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,  -- ✅ Store ENUM as String
    team_id INT,
    FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE SET NULL
);

INSERT INTO users (name, email, password, role_id, team_id) VALUES
    ('Alice Johnson', 'alice@example.com', 'password123', 1, NULL),  -- Admin (No team)
    ('Bob Smith', 'bob@example.com', 'password123', 2, 1),   -- Division Lead in Team 1
    ('Charlie Brown', 'charlie@example.com', 'password123', 3, 1), -- Team Member in Team 1
    ('David White', 'david@example.com', 'password123', 3, 2), -- Team Member in Team 2
    ('Eva Green', 'eva@example.com', 'password123', 4, 2),        -- Approver in Team 2
    ('Frank Black', 'frank@example.com', 'password123', 3, 3), -- Team Member in Team 3
    ('Grace Kelly', 'grace@example.com', 'password123', 3, 4), -- Team Member in Team 4
    ('Henry Ford', 'henry@example.com', 'password123', 2, 5), -- Division Lead in Team 5
    ('Isla Fisher', 'isla@example.com', 'password123', 3, 5), -- Team Member in Team 5
    ('Jack Reacher', 'jack@example.com', 'password123', 4, 4);    -- Approver in Team 4
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- Division Table
CREATE TABLE divisions (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

-- Team Table
CREATE TABLE teams (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    division_id INT NOT NULL,
    FOREIGN KEY (division_id) REFERENCES divisions(id) ON DELETE CASCADE
);

INSERT INTO divisions (name) VALUES
    ('Fleet'), ('Command'), ('Terrain'), ('Health'), ('Detect');

    -- Indexes for faster queries
    CREATE INDEX idx_division ON teams(division_id);
    CREATE INDEX idx_team ON users(team_id);




INSERT INTO roles (id, name) VALUES
    (1, 'ADMIN'),
    (2, 'DIVISION_LEAD'),
    (3, 'TEAM_MEMBER'),
    (4, 'APPROVER');

    INSERT INTO teams (name, division_id) VALUES
        ('Team Alpha', 1),  -- Division A
        ('Team Beta', 1),   -- Division A
        ('Team Gamma', 2),  -- Division B
        ('Team Delta', 2),  -- Division B
        ('Team Epsilon', 3),-- Division C
        ('Team Zeta', 3),   -- Division C
        ('Team Theta', 4),  -- Division D
        ('Team Lambda', 5); -- Division E
