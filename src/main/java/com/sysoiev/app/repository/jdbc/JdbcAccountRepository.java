package com.sysoiev.app.repository.jdbc;

import com.sysoiev.app.model.Account;
import com.sysoiev.app.model.AccountStatus;
import com.sysoiev.app.repository.AccountRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcAccountRepository implements AccountRepository {
    @Override
    public Account getById(Long aLong) {
        Account account = new Account();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE Id=?");
            preparedStatement.setLong(1, aLong);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                account.setId(resultSet.getLong("Id"));
                //preparedStatement.setString(1, MY_ENUM.name());
                // MyEnum enumVal =  MyEnum.valueOf(rs.getString("EnumColumn"));
                account.setAccountStatus(AccountStatus.valueOf(resultSet.getString("AccountStatus")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return account;
    }

    @Override
    public void deleteById(Long aLong) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM accounts WHERE Id = ?");
            preparedStatement.setLong(1, aLong);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Account update(Account item) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE accounts SET " +
                    "AccountStatus = ? WHERE Id = ?");

            preparedStatement.setString(1, item.getAccountStatus().toString());
            preparedStatement.setLong(2, item.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return item;
    }

    @Override
    public Account save(Account item) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO accounts (id)" +
                    "VALUES (?)");
            preparedStatement.setLong(1, item.getId());
            //preparedStatement.setObject(2, item.getAccountStatus());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return item;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM accounts");

            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getLong("Id"));
                account.setAccountStatus(AccountStatus.valueOf(resultSet.getString("AccountStatus")));

                accounts.add(account);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return accounts;
    }
}