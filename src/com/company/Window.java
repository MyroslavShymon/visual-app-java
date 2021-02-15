package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import static javax.swing.JOptionPane.showMessageDialog;

public class Window  extends JFrame {
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new JPanel();
        JPanel panel1Lb = new JPanel();
        JPanel panel1Btn = new JPanel();

        JPanel panel2 = new JPanel();
        JPanel panel2Lb = new JPanel();
        JPanel panel2Btn = new JPanel();

        JPanel panel3 = new JPanel();
        JPanel panel3Lb = new JPanel();
        JPanel panel3Btn = new JPanel();

        JPanel panel4 = new JPanel();
        JPanel panel4Btn = new JPanel();
        JPanel panel4Tab = new JPanel();

        JTextField performerFirstName = new JTextField();
        JTextField performerLastName = new JTextField();
        JTextField performerExperience = new JTextField();
        JTextField performerPosition = new JTextField();
        JTextField projectName = new JTextField();
        JTextField projectLang = new JTextField();
        JTextField projectDate = new JTextField();
        JTextField projectCost = new JTextField();
        JTextField projectStateRate = new JTextField();
        JTextField projectStateDescription = new JTextField();
        JTextField taskNum = new JTextField();
        JTextField taskTitle = new JTextField();
        JTextField taskSetting  = new JTextField();
        JTextField taskDate  = new JTextField();
        JTextField taskCost  = new JTextField();

        //Tab 1 comboBox
        JComboBox performerComboBoxPanel1 = new JComboBox();
        //Tab2 comboBox
        JComboBox performerComboBoxPanel2 = new JComboBox();
        JComboBox projectComboBoxPanel2 = new JComboBox();
        //Tab3 comboBox
        JComboBox projectComboBoxPanel3 = new JComboBox();
        JComboBox performerComboBoxPanel3 = new JComboBox();
        JComboBox taskComboBoxPanel3 = new JComboBox();

        //Tab 1 buttons
        JButton performerAddButton = new JButton("Додати");
        JButton performerDelButton = new JButton("Видалити");
        JButton performerEditButton = new JButton("Редагувати");
        JButton performerLoadButton = new JButton("Завантажити з файла");
        JButton performerSaveButton = new JButton("Зберегти у файл");
        //Tab 2 buttons
        JButton projectAddButton = new JButton("Додати");
        JButton projectDelButton = new JButton("Видалити");
        JButton projectEditButton = new JButton("Редагувати");
        JButton projectLoadButton = new JButton("Завантажити з файла");
        JButton projectSaveButton = new JButton("Зберегти у файл");
        JButton addPerformerButton = new JButton("Додати виконавця");
        //Tab 3 buttons
        JButton taskAddButton = new JButton("Додати");
        JButton taskDelButton = new JButton("Видалити");
        JButton taskEditButton = new JButton("Редагувати");
        JButton taskLoadButton = new JButton("Завантажити з файла");
        JButton taskSaveButton = new JButton("Зберегти у файл");
        //Tab 4 buttons
        JButton sortButton = new JButton("Сортувати");

        ArrayList<Performer> performers = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();
        ArrayList<Task> tasks = new ArrayList<>();

        String[] col = {
                "Ім'я виконавця",
                "Прізвище",
                "Стаж",
                "Посада",
                "Назва проекта",
                "Мова програмування",
                "Дата створення",
                "Стан",
                "Номер завдання",
                "Заголовок",
                "Пояснення",
                "Термін",
                "Ціна",
        };
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        JTable table = new JTable(tableModel);

        public Window() {
                super("Структура проектів");
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setBounds(400, 100, 1000, 700);
                this.add(tabbedPane);

                tabbedPane.addTab("Виконавець", panel1);
                tabbedPane.addTab("Проект", panel2);
                tabbedPane.addTab("Задача", panel3);
                tabbedPane.addTab("Таблиця", panel4);

                //Tab 1 layouts
                panel1.setLayout(new GridLayout(3, 1, 1, 5));
                panel1Lb.setLayout(new GridLayout(5, 2, 1, 5));
                panel1Btn.setLayout(new GridLayout(2, 3, 1, 5));
                //Tab 2 layouts
                panel2.setLayout(new GridLayout(2, 1, 1, 5));
                panel2Lb.setLayout(new GridLayout(8, 2, 1, 5));
                panel2Btn.setLayout(new GridLayout(2, 3, 1, 5));
                //Tab 3 layout
                panel3.setLayout(new GridLayout(2, 1, 1, 5));
                panel3Lb.setLayout(new GridLayout(8, 2, 1, 5));
                panel3Btn.setLayout(new GridLayout(2, 3, 1, 5));
                //Tab 4
                panel4.setLayout(new GridLayout(2, 1, 1, 5));
                panel4Tab.setLayout(new GridLayout(1, 1, 1,5));
                panel4Btn.setLayout(new GridLayout(3, 1, 1,5));

                //Tab 1 add
                panel1Lb.add(new JLabel("Ім'я виконавця", SwingConstants.CENTER));
                panel1Lb.add(performerFirstName);
                panel1Lb.add(new JLabel("Прізвище виконання", SwingConstants.CENTER));
                panel1Lb.add(performerLastName);
                panel1Lb.add(new JLabel("Стаж виконавця", SwingConstants.CENTER));
                panel1Lb.add(performerExperience);
                panel1Lb.add(new JLabel("Посада виконавця", SwingConstants.CENTER));
                panel1Lb.add(performerPosition);
                panel1Lb.add(new JLabel("Список виконавців", SwingConstants.CENTER));
                panel1Lb.add(performerComboBoxPanel1);
                panel1.add(panel1Lb);
                panel1.add(panel1Btn);
                panel1Btn.add(performerAddButton);
                panel1Btn.add(performerDelButton);
                panel1Btn.add(performerEditButton);
                panel1Btn.add(performerLoadButton);
                panel1Btn.add(performerSaveButton);
                //Tab 2 add
                panel2Lb.add(new JLabel("Список виконавців", SwingConstants.CENTER));
                panel2Lb.add(performerComboBoxPanel2);
                panel2Lb.add(new JLabel("Назва проекта", SwingConstants.CENTER));
                panel2Lb.add(projectName);
                panel2Lb.add(new JLabel("Мова програмування", SwingConstants.CENTER));
                panel2Lb.add(projectLang);
                panel2Lb.add(new JLabel("Дата створення", SwingConstants.CENTER));
                panel2Lb.add(projectDate);
                panel2Lb.add(new JLabel("Ціна проекта", SwingConstants.CENTER));
                panel2Lb.add(projectCost);
                panel2Lb.add(new JLabel("Стан виконання проекту у відсотках", SwingConstants.CENTER));
                panel2Lb.add(projectStateRate);
                panel2Lb.add(new JLabel("Пояснення стану виконання", SwingConstants.CENTER));
                panel2Lb.add(projectStateDescription);
                panel2Lb.add(new JLabel("Список проектів", SwingConstants.CENTER));
                panel2Lb.add(projectComboBoxPanel2);
                panel2.add(panel2Lb);
                panel2.add(panel2Btn);
                panel2Btn.add(projectAddButton);
                panel2Btn.add(projectDelButton);
                panel2Btn.add(projectEditButton);
                panel2Btn.add(projectLoadButton);
                panel2Btn.add(projectSaveButton);
                panel2Btn.add(addPerformerButton);
                //Tab 3 add
                panel3Lb.add(new JLabel("Список проектів", SwingConstants.CENTER));
                panel3Lb.add(projectComboBoxPanel3);
                panel3Lb.add(new JLabel("Список виконавців", SwingConstants.CENTER));
                panel3Lb.add(performerComboBoxPanel3);
                panel3Lb.add(new JLabel("Номер завдання", SwingConstants.CENTER));
                panel3Lb.add(taskNum);
                panel3Lb.add(new JLabel("Заголовок завдання", SwingConstants.CENTER));
                panel3Lb.add(taskTitle);
                panel3Lb.add(new JLabel("Пояснення завдання", SwingConstants.CENTER));
                panel3Lb.add(taskSetting);
                panel3Lb.add(new JLabel("Термін виконання завдання", SwingConstants.CENTER));
                panel3Lb.add(taskDate);
                panel3Lb.add(new JLabel("Ціна завдання", SwingConstants.CENTER));
                panel3Lb.add(taskCost);
                panel3Lb.add(new JLabel("Список завдань", SwingConstants.CENTER));
                panel3Lb.add(taskComboBoxPanel3);
                panel3.add(panel3Lb);
                panel3.add(panel3Btn);
                panel3Btn.add(taskAddButton);
                panel3Btn.add(taskDelButton);
                panel3Btn.add(taskEditButton);
                panel3Btn.add(taskLoadButton);
                panel3Btn.add(taskSaveButton);

                taskNum.addKeyListener(intListener);
                projectStateRate.addKeyListener(intListener);

                performerExperience.addKeyListener(doubleListener);
                projectCost.addKeyListener(doubleListener);
                taskCost.addKeyListener(doubleListener);

                performerFirstName.setHorizontalAlignment(JTextField.CENTER);
                performerLastName.setHorizontalAlignment(JTextField.CENTER);
                performerPosition.setHorizontalAlignment(JTextField.CENTER);
                projectName.setHorizontalAlignment(JTextField.CENTER);
                projectLang.setHorizontalAlignment(JTextField.CENTER);
                projectDate.setHorizontalAlignment(JTextField.CENTER);
                taskTitle.setHorizontalAlignment(JTextField.CENTER);
                taskSetting.setHorizontalAlignment(JTextField.CENTER);
                taskDate.setHorizontalAlignment(JTextField.CENTER);
                projectStateDescription.setHorizontalAlignment(JTextField.CENTER);

                table.setRowHeight(24);
                panel4Tab.add(table);
                panel4Tab.add(new JScrollPane(table));
                panel4Tab.add(table.getTableHeader());
                table.setDefaultEditor(Object.class, null);
                panel4Btn.add(sortButton);
                panel4.add(panel4Tab);
                panel4.add(panel4Btn);

                //Performer
                performerAddButton.addActionListener(actionListenerEvent -> {
                        if(
                                !performerFirstName.getText().isEmpty()
                                && !performerLastName.getText().isEmpty()
                                && !performerExperience.getText().isEmpty()
                                && !performerPosition.getText().isEmpty()
                        ) {
                                performers.add(new Performer(
                                        performerLastName.getText(),
                                        performerFirstName.getText(),
                                        performerPosition.getText(),
                                        Double.parseDouble(performerExperience.getText()))
                                );

                                performerLastName.setText("");
                                performerFirstName.setText("");
                                performerPosition.setText("");
                                performerExperience.setText("");
                                UpdatePerformerPanel();
                        }
                        else
                                showMessageDialog(null, "Заповніть всі поля вводу значеннями");
                });

                performerDelButton.addActionListener(actionListenerEvent -> {
                        if(performerComboBoxPanel1.getSelectedIndex() == -1)
                                showMessageDialog(null, "Виберіть елемент для видалення");
                        else {
                                performers.remove(performerComboBoxPanel1.getSelectedIndex());
                                UpdatePerformerPanel();
                        }
                });
                performerEditButton.addActionListener(actionListenerEvent -> {
                        if(performerComboBoxPanel1.getSelectedIndex() == -1)
                                showMessageDialog(null, "Виберіть елемент для редагування");
                        else {
                                if (
                                        !performerFirstName.getText().isEmpty()
                                                && !performerLastName.getText().isEmpty()
                                                && !performerExperience.getText().isEmpty()
                                                && !performerPosition.getText().isEmpty()
                                ) {
                                        performers.set(performerComboBoxPanel1.getSelectedIndex(),
                                                new Performer(
                                                        performerLastName.getText(),
                                                        performerFirstName.getText(),
                                                        performerPosition.getText(),
                                                        Double.parseDouble(performerExperience.getText()))
                                        );

                                        performerLastName.setText("");
                                        performerFirstName.setText("");
                                        performerPosition.setText("");
                                        performerExperience.setText("");
                                        UpdatePerformerPanel();
                                        showMessageDialog(null, "Запис редаговано");
                                } else
                                        showMessageDialog(null, "Заповніть всі поля вводу значеннями");
                        }
                });
                performerSaveButton.addActionListener(actionListenerEvent -> {
                        if(performers.size() == 0)
                                showMessageDialog(null, "Немає жодного запису для збереження");
                        else {
                                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("performer.dat"))) {
                                        oos.writeObject(performers);
                                } catch (Exception ex) {
                                        System.out.println(ex.getMessage());
                                }
                                showMessageDialog(null, "Записи збережено у файл");
                        }
                });
                performerLoadButton.addActionListener(actionListenerEvent -> {
                        ArrayList<Performer> list = new ArrayList<>();

                        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("performer.dat")))
                        {
                                list =(ArrayList<Performer>) ois.readObject();
                        }
                        catch(Exception ex){ System.out.println(ex.getMessage()); }

                        if(list.size() == 0)
                                showMessageDialog(null, "Файл пустий або його не існує");
                        else {
                                performers = list;
                                UpdatePerformerPanel();
                                showMessageDialog(null, "Записи з файла успішно завантажено");
                        }
                });

                //Project
                projectAddButton.addActionListener(actionListenerEvent -> {
                        if(
                                !projectName.getText().isEmpty()
                                && !projectLang.getText().isEmpty()
                                && !projectStateRate.getText().isEmpty()
                                && !projectCost.getText().isEmpty()
                                && !projectDate.getText().isEmpty()
                                && !projectStateDescription.getText().isEmpty()
                                && !(performerComboBoxPanel2.getSelectedIndex() == -1)
                        ) {
                                projects.add(new Project(
                                        Integer.parseInt(projectStateRate.getText()),
                                        projectStateDescription.getText(),
                                        projectName.getText(),
                                        projectLang.getText(),
                                        projectDate.getText(),
                                        Double.parseDouble(projectCost.getText()),
                                        performers.get(performerComboBoxPanel2.getSelectedIndex()))
                                );

                                performers.remove(performerComboBoxPanel2.getSelectedIndex());
                                projectStateRate.setText("");
                                projectStateDescription.setText("");
                                projectName.setText("");
                                projectLang.setText("");
                                projectDate.setText("");
                                projectCost.setText("");
                                UpdatePerformerPanel();
                                UpdateProjectPanel();
                        }
                        else
                                showMessageDialog(null, "Заповніть всі поля вводу значеннями");
                });
                addPerformerButton.addActionListener(actionListenerEvent -> {
                        if(projectComboBoxPanel2.getSelectedIndex() == -1 || performerComboBoxPanel2.getSelectedIndex() == -1)
                                showMessageDialog(null, "Виберіть проект та виконавця");
                        else
                        {
                                projects.get(projectComboBoxPanel2.getSelectedIndex()).setPerformers(performers.get(performerComboBoxPanel2.getSelectedIndex()));
                                performers.remove(performerComboBoxPanel2.getSelectedIndex());
                                UpdatePerformerPanel();
                                UpdateProjectPanel();
                        }
                });
                projectDelButton.addActionListener(actionListenerEvent -> {
                        if(projectComboBoxPanel2.getSelectedIndex() == -1)
                                showMessageDialog(null, "Виберіть елемент для видалення");
                        else {
                                for(Performer performer : projects.get(projectComboBoxPanel2.getSelectedIndex()).getPerformers())
                                {
                                        performers.add(performer);
                                }
                                projects.remove(projectComboBoxPanel2.getSelectedIndex());
                                UpdateProjectPanel();
                                UpdatePerformerPanel();
                        }
                });
                projectEditButton.addActionListener(actionListenerEvent -> {
                        if(projectComboBoxPanel2.getSelectedIndex() == -1)
                                showMessageDialog(null, "Заповніть всі поля вводу значеннями");
                        else {
                                if (
                                        !projectName.getText().isEmpty()
                                                && !projectLang.getText().isEmpty()
                                                && !projectStateRate.getText().isEmpty()
                                                && !projectCost.getText().isEmpty()
                                                && !projectDate.getText().isEmpty()
                                                && !projectStateDescription.getText().isEmpty()
                                ) {
                                        projects.get(projectComboBoxPanel2.getSelectedIndex()).EditProject(
                                                Integer.parseInt(projectStateRate.getText()),
                                                projectStateDescription.getText(),
                                                projectName.getText(),
                                                projectLang.getText(),
                                                projectDate.getText(),
                                                Double.parseDouble(projectCost.getText())
                                        );

                                        projectStateRate.setText("");
                                        projectStateDescription.setText("");
                                        projectName.setText("");
                                        projectLang.setText("");
                                        projectDate.setText("");
                                        projectCost.setText("");
                                        UpdateProjectPanel();
                                } else
                                        showMessageDialog(null, "Заповніть всі поля вводу значеннями");
                        }
                });
                projectSaveButton.addActionListener(actionListenerEvent -> {
                        if(projects.size() == 0)
                                showMessageDialog(null, "Немає жодного запису для збереження");
                        else {
                                try (ObjectOutputStream InputStreamProject = new ObjectOutputStream(new FileOutputStream("projects.dat"))) {
                                        InputStreamProject.writeObject(projects);
                                } catch (Exception exception) {
                                        System.out.println(exception.getMessage());
                                }
                                showMessageDialog(null, "Записи збережено у файл");
                        }
                });
                projectLoadButton.addActionListener(actionListenerEvent -> {
                        ArrayList<Project> listProjects = new ArrayList<>();

                        try(ObjectInputStream OutputStreamProject = new ObjectInputStream(new FileInputStream("projects.dat")))
                        {
                                listProjects =(ArrayList<Project>) OutputStreamProject.readObject();
                        }
                        catch(Exception ex){ System.out.println(ex.getMessage()); }

                        if(listProjects.size() == 0)
                                showMessageDialog(null, "Файл пустий або його не існує");
                        else {
                                projects = listProjects;
                                for (Project project : projects)
                                        for (Performer seller : project.getPerformers())
                                                performers.add(seller);

                                UpdateTaskPanel();
                                UpdateProjectPanel();
                                UpdatePerformerPanel();
                                showMessageDialog(null, "Записи з файла успішно завантажено");
                        }
                });

                //Tasks
                taskAddButton.addActionListener(actionListenerEvent -> {
                        if(!taskNum.getText().isEmpty()
                                && !taskTitle.getText().isEmpty()
                                && !taskSetting.getText().isEmpty()
                                && !taskDate.getText().isEmpty()
                                && !taskCost.getText().isEmpty()
                                && !(projectComboBoxPanel3.getSelectedIndex() == -1)
                                && !(performerComboBoxPanel3.getSelectedIndex() == -1)) {
                                tasks.add(new Task(
                                                                        Integer.parseInt(taskNum.getText()),
                                                                        taskTitle.getText(),
                                                                        taskSetting.getText(),
                                                                        taskDate.getText(),
                                                                        Double.parseDouble(taskCost.getText()),
                                        projects.get(projectComboBoxPanel3.getSelectedIndex()).getPerformers().get(performerComboBoxPanel3.getSelectedIndex()),
                                        projects.get(projectComboBoxPanel3.getSelectedIndex()))
                                );

                                taskNum.setText("");
                                taskTitle.setText("");
                                taskSetting.setText("");
                                taskDate.setText("");
                                taskCost.setText("");
                                UpdateTaskPanel();
                                UpdateTable();

                        }
                        else
                                showMessageDialog(null, "Заповніть всі поля вводу значеннями");
                });
                taskDelButton.addActionListener(actionListenerEvent -> {
                        if(taskComboBoxPanel3.getSelectedIndex() == -1)
                                showMessageDialog(null, "Виберіть елемент для видалення");
                        else {
                                tasks.remove(taskComboBoxPanel3.getSelectedIndex());
                                UpdateTaskPanel();
                                UpdateTable();
                        }
                });
                taskEditButton.addActionListener(actionListenerEvent -> {
                        if(performerComboBoxPanel3.getSelectedIndex() == -1)
                                showMessageDialog(null, "Виберіть елемент для редагування");
                        else {
                                if (
                                        !taskNum.getText().isEmpty()
                                                && !taskTitle.getText().isEmpty()
                                                && !taskSetting.getText().isEmpty()
                                                && !taskDate.getText().isEmpty()
                                                && !taskCost.getText().isEmpty()
                                                && !(taskComboBoxPanel3.getSelectedIndex() == -1)
                                ) {
                                        tasks.set(taskComboBoxPanel3.getSelectedIndex(),
                                                new Task(
                                                        Integer.parseInt(taskNum.getText()),
                                                        taskTitle.getText(),
                                                        taskSetting.getText(),
                                                        taskDate.getText(),
                                                        Double.parseDouble(taskCost.getText()),
                                                        projects.get(projectComboBoxPanel3.getSelectedIndex()).getPerformers().get(performerComboBoxPanel3.getSelectedIndex()),
                                                        projects.get(projectComboBoxPanel3.getSelectedIndex())
                                                ));

                                        taskNum.setText("");
                                        taskTitle.setText("");
                                        taskSetting.setText("");
                                        taskDate.setText("");
                                        taskCost.setText("");
                                        UpdateTaskPanel();
                                        UpdateTable();
                                } else
                                        showMessageDialog(null, "Заповніть всі поля вводу значеннями");
                        }
                });
                taskSaveButton.addActionListener(actionListenerEvent -> {
                        if(tasks.size() == 0)
                                showMessageDialog(null, "Немає жодного запису для збереження");
                        else {
                                try (ObjectOutputStream InputStreamTasks = new ObjectOutputStream(new FileOutputStream("tasks.dat"))) {
                                        InputStreamTasks.writeObject(tasks);
                                } catch (Exception exception) {
                                        System.out.println(exception.getMessage());
                                }
                                showMessageDialog(null, "Записи збережено у файл");
                        }
                });
                taskLoadButton.addActionListener(actionListenerEvent -> {
                        ArrayList<Task> listTasks = new ArrayList<>();

                        try(ObjectInputStream OutputStreamTasks = new ObjectInputStream(new FileInputStream("tasks.dat")))
                        {
                                listTasks =(ArrayList<Task>) OutputStreamTasks.readObject();
                        }
                        catch(Exception exception){ System.out.println(exception.getMessage()); }

                        if(listTasks.size() == 0)
                                showMessageDialog(null, "Файл пустий або його не існує");
                        else {
                                tasks = listTasks;
                                for (Task task : tasks)
                                {
                                        projects.add(task.getProject());
                                        performers.add(task.getPerformer());
                                }
                                UpdateTaskPanel();
                                UpdateProjectPanel();
                                UpdatePerformerPanel();
                                UpdateTable();
                                showMessageDialog(null, "Записи з файла успішно завантажено");
                        }
                });

                projectComboBoxPanel3.addActionListener(actionListenerEvent -> {
                        UpdatePerformersPanel3();
                });

                sortButton.addActionListener(actionListenerEvent -> {
                        Collections.sort(tasks);
                        UpdateTable();
                });
        }

        public void UpdateTaskPanel() {
                taskComboBoxPanel3.removeAllItems();
                for(Task item : tasks) {
                        taskComboBoxPanel3.addItem(item.toString());
                }
                taskComboBoxPanel3.setSelectedIndex(-1);
        }

        public void UpdatePerformerPanel() {
                performerComboBoxPanel1.removeAllItems();
                performerComboBoxPanel2.removeAllItems();
                for(Performer performer : performers) {
                        performerComboBoxPanel1.addItem(performer.toString());
                        performerComboBoxPanel2.addItem(performer.toString());
                }
                performerComboBoxPanel1.setSelectedIndex(-1);
                performerComboBoxPanel2.setSelectedIndex(-1);
        }

        public void UpdateProjectPanel() {
                projectComboBoxPanel2.removeAllItems();
                projectComboBoxPanel3.removeAllItems();
                for(Project project : projects) {
                        projectComboBoxPanel2.addItem(project.toString());
                        projectComboBoxPanel3.addItem(project.toString());
                }
                projectComboBoxPanel2.setSelectedIndex(-1);
        }

        public void UpdatePerformersPanel3() {
                if (projectComboBoxPanel3.getSelectedIndex() == -1)
                        return;
                else {
                        performerComboBoxPanel3.removeAllItems();
                        for (Performer item : projects.get(projectComboBoxPanel3.getSelectedIndex()).getPerformers()) {
                                performerComboBoxPanel3.addItem(item.toString());
                        }
                }
        }

        public void UpdateTable() {
                for (int i = tableModel.getRowCount() - 1; i >= 0; i--)
                        tableModel.removeRow(i);

                for (Task item : tasks) {
                        Object[] object = {
                                item.getPerformer().getFirstName(),
                                item.getPerformer().getLastName(),
                                item.getPerformer().getExperience(),
                                item.getPerformer().getPosition(),
                                item.getProject().getName(),
                                item.getProject().getLang(),
                                item.getProject().getDate(),
                                item.getProject().getRate(),
                                item.getNumber(),
                                item.getTitle(),
                                item.getSetting(),
                                item.getDate(),
                                item.getCost(),
                        };
                        tableModel.addRow(object);
                }
        }
        KeyListener intListener = new KeyAdapter() {
                public void keyTyped(KeyEvent event) {
                        char symbol = event.getKeyChar();
                        if (!((symbol >= '0') && (symbol <= '9') ||
                                (symbol == KeyEvent.VK_BACK_SPACE) ||
                                (symbol == KeyEvent.VK_DELETE))) {
                                getToolkit().beep();
                                event.consume();
                        }
                }
        };

        KeyListener doubleListener = new KeyAdapter() {
                public void keyTyped(KeyEvent event) {
                        char symbol = event.getKeyChar();
                        if (!((symbol >= '0') && (symbol <= '9') || (symbol == '.') ||
                                (symbol == KeyEvent.VK_BACK_SPACE) ||
                                (symbol == KeyEvent.VK_DELETE))) {
                                getToolkit().beep();
                                event.consume();
                        }
                }
        };
}
