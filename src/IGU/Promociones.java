/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IGU;

import Modelos.Fecha;
import Modelos.Producto;
import Modelos.Promocion;
import Servicios.ServicioProducto;
import Servicios.ServicioPromocion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author giaan
 */
public class Promociones extends javax.swing.JFrame {

    ServicioPromocion servProm = new ServicioPromocion();
    ServicioProducto servP = new ServicioProducto();
    DefaultListModel lProd = new DefaultListModel();
    List<Producto> filtrado;
    ArrayList<Producto> listaProducto = new ArrayList<>();
    ArrayList<Producto> listaSeleccion = new ArrayList<>();
    ArrayList<Promocion> listaPromos = new ArrayList<>();
    private static Promociones instance;

    public static Promociones getInstance() {
        if (instance == null) {
            // La primera vez que se llame a este método,
            // la instancia es nula por lo cual se crea por primera y única vez.
            instance = new Promociones();
        }
        return instance; // Y devuelve siempre la misma instancia :)
    }

    public Promociones() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        llenarTablaMuestra();
        llenarTablaPromos();

    }

    public final void llenarTablaPromos() {

        listaPromos = servProm.todasLasPromos();
        Object[] promo = new Object[7];
        DefaultTableModel model = (DefaultTableModel) tablaPromos.getModel();

        for (Promocion p : listaPromos) {

            promo[0] = p.getId_producto();
            promo[1] = p.getNombre_promocion();
            promo[2] = p.getDescuento();
            promo[3] = p.getCantidad_minima();
            promo[4] = p.getFecha_desde();
            promo[5] = p.getFecha_hasta();
            if (p.isVigente()) {
                promo[6] = "SI";
            } else {
                promo[6] = "NO";
            }
            model.addRow(promo);

            tablaPromos.setModel(model);
        }
    }

    public final void llenarTablaMuestra() {

        listaProducto = servP.listarProductos();
        Object[] producto = new Object[5];
        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();

        for (Producto p : listaProducto) {

            producto[0] = p.getId_producto();
            producto[1] = p.getNombre_producto();
            producto[2] = p.getPrecio_con_iva();
            producto[3] = p.getPrecio_al_publico();
            producto[4] = p.getCodigo_barra();

            model.addRow(producto);
        }

        tablaProductos.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        dateFactura = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomPromocion = new javax.swing.JTextField();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        txtDescuento = new javax.swing.JSpinner();
        btnAlta = new javax.swing.JButton();
        txtCMinim = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listProd = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        txtFiltroNombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPromos = new javax.swing.JTable();

        dateFactura.setDateFormatString("yyyy-MM-dd");
        dateFactura.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("NOMBRE PROMOCIÓN");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DESCUENTO");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DESDE");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CANTIDAD MINIMA");

        txtNomPromocion.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        fechaDesde.setDateFormatString("yyyy-MM-dd");
        fechaDesde.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        fechaHasta.setDateFormatString("yyyy-MM-dd");
        fechaHasta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        txtDescuento.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txtDescuento.setModel(new javax.swing.SpinnerNumberModel(5, 5, 100, 5));

        btnAlta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAlta.setText("ALTA");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        txtCMinim.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txtCMinim.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("HASTA");

        tablaProductos.setBackground(new java.awt.Color(28, 130, 173));
        tablaProductos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tablaProductos.setForeground(new java.awt.Color(51, 51, 51));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "PRECIO_IVA", "PRECIO_PUBLICO", "C_BARRA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaProductos.setRowHeight(25);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setResizable(false);
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(70);
            tablaProductos.getColumnModel().getColumn(1).setResizable(false);
            tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(300);
            tablaProductos.getColumnModel().getColumn(2).setResizable(false);
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tablaProductos.getColumnModel().getColumn(3).setResizable(false);
            tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(130);
            tablaProductos.getColumnModel().getColumn(4).setResizable(false);
            tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        listProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listProdKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(listProd);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("PRODUCTOS AGREGADOS A LA PROMOCIÓN");

        txtFiltroNombre.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtFiltroNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroNombreKeyReleased(evt);
            }
        });

        txtCodigo.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("FILTRAR NOMBRE");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("FILTRAR CODIGO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNomPromocion)
                                .addComponent(fechaDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fechaHasta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDescuento)
                                .addComponent(txtCMinim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(262, 262, 262))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(29, 29, 29)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(79, 79, 79))))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNomPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCMinim, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Alta de promoción", jPanel2);
        jTabbedPane1.addTab("", jTabbedPane2);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        tablaPromos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        tablaPromos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE_PROMO", "DESCUENTO", "C_MINIMA", "DESDE", "HASTA", "VIGENTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPromos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaPromos.setRowHeight(25);
        tablaPromos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPromosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaPromos);
        if (tablaPromos.getColumnModel().getColumnCount() > 0) {
            tablaPromos.getColumnModel().getColumn(0).setResizable(false);
            tablaPromos.getColumnModel().getColumn(1).setResizable(false);
            tablaPromos.getColumnModel().getColumn(1).setPreferredWidth(227);
            tablaPromos.getColumnModel().getColumn(2).setResizable(false);
            tablaPromos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tablaPromos.getColumnModel().getColumn(3).setResizable(false);
            tablaPromos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablaPromos.getColumnModel().getColumn(4).setResizable(false);
            tablaPromos.getColumnModel().getColumn(4).setPreferredWidth(150);
            tablaPromos.getColumnModel().getColumn(5).setResizable(false);
            tablaPromos.getColumnModel().getColumn(5).setPreferredWidth(150);
            tablaPromos.getColumnModel().getColumn(6).setResizable(false);
            tablaPromos.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ver promociones", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        filtrado = listaProducto.stream().filter(x -> x.getCodigo_barra().contains(txtCodigo.getText())).collect(Collectors.toList());
        tablaProductos.removeAll();

        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        model.setRowCount(0);
        Object[] producto = new Object[5];

        for (Producto p : filtrado) {

            producto[0] = p.getId_producto();
            producto[1] = p.getNombre_producto();
            producto[2] = p.getPrecio_con_iva();
            producto[3] = p.getPrecio_al_publico();
            producto[4] = p.getCodigo_barra();

            model.addRow(producto);

        }
        tablaProductos.setModel(model);
    }

    /*
    }//GEN-LAST:event_txtCodigoKeyReleased
*/
    private void txtFiltroNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroNombreKeyReleased
        filtrado = listaProducto.stream().filter(x -> x.getNombre_producto().contains(txtFiltroNombre.getText().toUpperCase())).collect(Collectors.toList());
        tablaProductos.removeAll();

        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        model.setRowCount(0);
        Object[] producto = new Object[5];

        for (Producto p : filtrado) {

            producto[0] = p.getId_producto();
            producto[1] = p.getNombre_producto();
            producto[2] = p.getPrecio_con_iva();
            producto[3] = p.getPrecio_al_publico();
            producto[4] = p.getCodigo_barra();

            model.addRow(producto);

        }
    }//GEN-LAST:event_txtFiltroNombreKeyReleased

    private void listProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listProdKeyPressed
        int key = evt.getKeyChar();
        DefaultListModel model = (DefaultListModel) listProd.getModel();

        int index = listProd.getSelectedIndex();

        if (key == 127 && model.getSize() > 0) {

            model.remove(index);

        }
    }//GEN-LAST:event_listProdKeyPressed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked

        int fila = tablaProductos.getSelectedRow();
        int columna = tablaProductos.getSelectedColumn();
        String id = String.valueOf(tablaProductos.getValueAt(fila, 0)).trim();
        String elemento;
        System.out.println(listaProducto);
        for (Producto p : listaProducto) {
            if (p.getId_producto() == Integer.parseInt(id)) {
                elemento = id + " - " + p.getNombre_producto() + " - " + p.getCodigo_barra();
                addElementToList(elemento);
            }
        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Verificación de campos vacíos en un método separado
        if (areFieldsEmpty()) {
            JOptionPane.showMessageDialog(this, "ALERTA! Hay campos vacíos.");
            return;
        }

        // Asignación de datos del formulario
        String nombre_promo = txtNomPromocion.getText();
        int cantidad = (int) txtCMinim.getValue();
        int descuento = (int) txtDescuento.getValue();
        String fechaD = formatter.format(fechaDesde.getDate());
        String fechaH = formatter.format(fechaHasta.getDate());

        // Mapeo de productos para búsqueda rápida por ID
        Map<Integer, Producto> productoMap = listaProducto.stream()
                .collect(Collectors.toMap(Producto::getId_producto, p -> p));

        // Procesar la lista seleccionada
        for (int i = 0; i < listProd.getModel().getSize(); i++) {
            String id = listProd.getModel().getElementAt(i).split(" ")[0];
            Producto productoSeleccionado = productoMap.get(Integer.parseInt(id));

            if (productoSeleccionado != null) {
                listaSeleccion.add(productoSeleccionado);
            }
        }

        // Intentar registrar la promoción
        boolean alta = servProm.altaPromocion(nombre_promo, cantidad, descuento, cantidad, fechaD, fechaH, listaSeleccion);

        // Si la alta es exitosa, limpiar el formulario
        if (alta) {
            resetForm();
        } else {
            JOptionPane.showMessageDialog(this, "Un producto ya tiene una promoción vigente, verifiqueló.");
        }
    }//GEN-LAST:event_btnAltaActionPerformed

    // Método para verificar si hay campos vacíos
    private boolean areFieldsEmpty() {
        return txtCMinim.getValue().equals("") || txtDescuento.getValue().equals("")
                || txtNomPromocion.getText().isEmpty() || fechaDesde.getDate() == null
                || fechaHasta.getDate() == null || listProd.getModel().getSize() < 1;
    }

// Método para limpiar el formulario
    private void resetForm() {
        txtNomPromocion.setText("");
        txtCMinim.setValue(2);
        txtDescuento.setValue(5);
        fechaDesde.setDate(null);
        fechaHasta.setDate(null);
        listaSeleccion.clear();
        lProd.clear(); // Si es necesario limpiar también el modelo gráfico de la lista
    }

    private void tablaPromosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPromosMouseClicked
          if (tablaPromos.getSelectedColumn() == 5) {
        try {
            int row = tablaPromos.getSelectedRow();
            int idPromo = (int) tablaPromos.getValueAt(row, 0);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            
            // Obtener fecha actual
            Date fechaHoy = new Date(); // Fecha actual
            Date fechaActual = formatter.parse(formatter.format(fechaHoy));
            
            // Solicitar nueva fecha
            String nuevaFechaStr = JOptionPane.showInputDialog("Seleccion nueva fecha", tablaPromos.getValueAt(row, 5));
            if (nuevaFechaStr == null || nuevaFechaStr.trim().isEmpty()) {
                return; // Salir si no se ingresa una fecha
            }
            
            Date fechaNueva = formatter.parse(nuevaFechaStr);
            Promocion promocion = listaPromos.stream()
                                             .filter(p -> p.getId_producto() == idPromo)
                                             .findFirst()
                                             .orElse(null);

            if (promocion != null) {
                Date fechaHasta = formatter.parse(promocion.getFecha_hasta());
                
                if (fechaNueva.equals(fechaHasta)) {
                    JOptionPane.showMessageDialog(this, "La fecha ingresada es la misma que la actual en la promoción.");
                } else if (fechaNueva.before(fechaActual)) {
                    JOptionPane.showMessageDialog(this, "La fecha ingresada es anterior a la fecha actual.");
                } else {
                    // Aquí podrías actualizar la fecha en la promoción si es necesario
                     promocion.setFecha_hasta(formatter.format(fechaNueva));
                     servProm.cambiarFechaHasta(idPromo, formatter.format(fechaNueva));
                     DefaultTableModel model = (DefaultTableModel) tablaPromos.getModel();
                    model.setValueAt(formatter.format(fechaNueva), row, 5);
                    JOptionPane.showMessageDialog(this, "Fecha de la promoción actualizada correctamente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Promoción no encontrada.");
            }
        } catch (ParseException ex) {
            Logger.getLogger(Promociones.class.getName()).log(Level.SEVERE, "Error al procesar la fecha", ex);
            JOptionPane.showMessageDialog(this, "Formato de fecha no válido.");
        }
    }


    }//GEN-LAST:event_tablaPromosMouseClicked

    //tablaProductos.setModel(model);        todos_los_estudiantes.setModel(model);    }                                     
    private void addElementToList(String element) {

        if (!lProd.contains(element)) {
            lProd.addElement(element);
            listProd.setModel(lProd);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Promociones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Promociones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Promociones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Promociones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Promociones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private com.toedter.calendar.JDateChooser dateFactura;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JList<String> listProd;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaPromos;
    private javax.swing.JSpinner txtCMinim;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JSpinner txtDescuento;
    private javax.swing.JTextField txtFiltroNombre;
    private javax.swing.JTextField txtNomPromocion;
    // End of variables declaration//GEN-END:variables
}
