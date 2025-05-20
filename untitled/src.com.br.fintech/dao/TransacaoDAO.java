package dao;

import model.Transacao;
import java.sql.*;
import java.util.List;

public abstract class TransacaoDAO {

    public abstract void insert(Transacao transacao);
    public abstract List<Transacao> getAll();
}
