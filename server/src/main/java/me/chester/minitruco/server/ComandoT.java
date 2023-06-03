package me.chester.minitruco.server;

/* SPDX-License-Identifier: BSD-3-Clause */
/* Copyright © 2005-2023 Carlos Duarte do Nascimento "Chester" <cd@pobox.com> */

/**
 * Pede Truco (ou seis, nove, doze)
 */

public class ComandoT extends Comando {

    @Override
    public void executa(String[] args, JogadorConectado j) {
        if (!j.jogando)
            return;
        j.getSala().getPartida().aumentaAposta(j);
    }

}
