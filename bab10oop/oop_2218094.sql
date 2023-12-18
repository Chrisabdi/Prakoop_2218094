-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 18 Des 2023 pada 14.39
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop_2218094`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_jualmakan`
--

CREATE TABLE `tb_jualmakan` (
  `ID` int(12) NOT NULL,
  `Menu` varchar(200) NOT NULL,
  `Pilihan` varchar(200) NOT NULL,
  `Porsi` varchar(200) NOT NULL,
  `Harga` varchar(200) NOT NULL,
  `Total Bayar` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_jualmakan`
--

INSERT INTO `tb_jualmakan` (`ID`, `Menu`, `Pilihan`, `Porsi`, `Harga`, `Total Bayar`) VALUES
(1, 'Makanan', 'Roasted Beef', '3', '35000', '105000'),
(2, 'Minuman', 'EsTeh', '2', '25000', '50000');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_jualmakan`
--
ALTER TABLE `tb_jualmakan`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_jualmakan`
--
ALTER TABLE `tb_jualmakan`
  MODIFY `ID` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
