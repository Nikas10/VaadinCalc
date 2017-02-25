package com.Typography.uis;

import javax.servlet.annotation.WebServlet;
import javax.xml.soap.Text;

import com.Typography.entity.*;
import com.Typography.service.MeasureService;
import com.Typography.service.impl.*;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.AbstractBeanContainer;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.sql.Timestamp;
import java.util.*;
import java.util.Calendar;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        //==============services block=====================
        ColorImpl colService = new ColorImpl();
        CurrencyImpl curService = new CurrencyImpl();
        MattertypeImpl mtService = new MattertypeImpl();
        MeasureImpl meService = new MeasureImpl();
        PrintertypeImpl ptService = new PrintertypeImpl();
        DensitypriceImpl dpService = new DensitypriceImpl();
        DigitdevicesImpl ddService = new DigitdevicesImpl();
        MatterImpl matService = new MatterImpl();
        //=================================================



        VerticalLayout layout = new VerticalLayout();
        HorizontalLayout crudcolor  = new HorizontalLayout();
        HorizontalLayout crudcurrency  = new HorizontalLayout();

        HorizontalLayout crudmatter = new HorizontalLayout();
        VerticalLayout statmatter = new VerticalLayout();
        VerticalLayout buttonmatter = new VerticalLayout();
        VerticalLayout gridmatter = new VerticalLayout();

        Grid rcolor =  new Grid();
        Grid rcurrency = new Grid();
        Grid rmatter = new Grid();


        TextField ncolor = new TextField();
        TextField ncurrency = new TextField();


        TextField nmatter = new TextField();
        nmatter.setCaption("Enter matter name(int)");
        TextField lmatter = new TextField();
        lmatter.setCaption("Enter matter lenght(int)");
        TextField wmatter = new TextField();
        wmatter.setCaption("Enter matter width(int)");
        TextField denmatter = new TextField();
        denmatter.setCaption("Enter matter density(int)");
        TextField pmatter = new TextField();
        pmatter.setCaption("Enter matter price(double type)");
        ComboBox mtidmatter = new ComboBox();
        mtidmatter.setCaption("Choose matter type");
        ComboBox meidmatter = new ComboBox();
        meidmatter.setCaption("Choose matter measure");
        ComboBox curridmatter = new ComboBox();
        curridmatter.setCaption("Choose currency");

        //===getting List<? extends Serializable> for comboboxes============
        List<mattertype> mtlist = mtService.getAll();
        List<measure> melist = meService.getAll();
        List<currency> curlist = curService.getAll();

        Map<String, mattertype> mtmap = new HashMap<>();
        for (mattertype mt: mtlist)
        {
            mtmap.put(mt.getName(), mt);
        }
        Map<String, measure> memap = new HashMap<>();
        for (measure me: melist)
        {
            memap.put(me.getName(), me);
        }
        Map<String, currency> curmap = new HashMap<>();
        for (currency cu: curlist)
        {
            curmap.put(cu.getName(), cu);
        }
        mtidmatter.setNullSelectionAllowed(true);
        meidmatter.setNullSelectionAllowed(true);
        curridmatter.setNullSelectionAllowed(true);
        mtidmatter.clear(); meidmatter.clear(); curridmatter.clear();
        mtidmatter.addItems(mtmap.keySet());

        meidmatter.addItems(memap.keySet());
        curridmatter.addItems(curmap.keySet());
        //==================================================================

        Button dcolor = new Button("Delete");
        dcolor.setEnabled(false);
        Button dcurrency = new Button("Delete");
        dcurrency.setEnabled(false);
        Button dmatter = new Button("Delete");
        dmatter.setEnabled(false);

        Button ucolor = new Button("Update color");
        ucolor.setEnabled(false);
        Button ucurrency = new Button("Update currency");
        ucurrency.setEnabled(false);
        Button umatter = new Button("Update matter");
        umatter.setEnabled(false);

        Button acolor = new Button("Add new color");
        Button acurrency = new Button("Add new currency");
        Button amatter = new Button("Add new matter");

        Button gcolor = new Button("Get all colors");
        Button gcurrency = new Button("Get all currencies");
        Button gmatter = new Button("Get all matters");


        acolor.addClickListener( e -> {
            String name = ncolor.getValue();
            if (!name.equals(""))
            {
                color newcolor = new color();
                newcolor.setName(name);
                colService.add(newcolor);
            }
        });
        acurrency.addClickListener( e -> {
            String cname = ncurrency.getValue();
            if (!cname.equals(""))
            {
                currency newcurr = new currency();
                newcurr.setName(cname);
                curService.add(newcurr);
            }
        });

        amatter.addClickListener(e ->{
            String mname = nmatter.getValue();
            if (!mname.equals(""))
            {
                matter newmatter = new matter();
                newmatter.setName(mname);
                if (wmatter.equals(""))
                    newmatter.setWidth(0); else newmatter.setWidth(Integer.parseInt(wmatter.getValue()));
                if (lmatter.equals(""))
                    newmatter.setLenght(0); else newmatter.setLenght(Integer.parseInt(lmatter.getValue()));
                if (denmatter.equals(""))
                    newmatter.setDensity(0); else newmatter.setDensity(Integer.parseInt(denmatter.getValue()));
                Double dd = new Double(0.0);
                if (pmatter.equals(""))
                    newmatter.setPrice(dd); else newmatter.setPrice(Double.parseDouble(pmatter.getValue()));

                newmatter.setCurrmt(curmap.get((String)curridmatter.getValue()));
                newmatter.setMeid(memap.get((String)meidmatter.getValue()));
                newmatter.setMtid(mtmap.get((String)mtidmatter.getValue()));
                matService.add(newmatter);
            }
        });


        gcolor.addClickListener( e -> {
            List<color> clist = colService.getAll();
            rcolor.setContainerDataSource(new BeanItemContainer<>(color.class,clist));
        });
        gcurrency.addClickListener( e -> {
            List<currency> culist = curService.getAll();
            rcurrency.setContainerDataSource(new BeanItemContainer<>(currency.class,culist));
        });
        gmatter.addClickListener(e -> {
            List<matter> mlist = matService.getAll();
            rmatter.setContainerDataSource(new BeanItemContainer<>(matter.class, mlist));
            //rmatter.setColumns();
        });


        rcolor.addSelectionListener(e -> {
            color selected = (color)rcolor.getSelectedRow();
            if (!(selected == null)) {
                dcolor.setEnabled(true);
                dcolor.addClickListener(d -> {
                    if (selected != null) colService.delete(selected);
                    ucolor.setEnabled(false);
                    dcolor.setEnabled(false);
                    List<color> clist = colService.getAll();
                    rcolor.setContainerDataSource(new BeanItemContainer<>(color.class, clist));
                });
                ucolor.setEnabled(true);
                ucolor.addClickListener(u -> {
                    if (selected!=null)
                    {
                        if (!ncolor.equals("")) {
                            selected.setName(ncolor.getValue());
                            colService.update(selected);
                        }
                            ucolor.setEnabled(false);
                            dcolor.setEnabled(false);
                            List<color> clist = colService.getAll();
                            rcolor.setContainerDataSource(new BeanItemContainer<>(color.class, clist));
                    }

                });

            }
        });
        rcurrency.addSelectionListener(e -> {
            currency sel = (currency)rcurrency.getSelectedRow();
            if (sel != null) {
                dcurrency.setEnabled(true);
                ucurrency.setEnabled(true);
                dcurrency.addClickListener(d -> {
                    if (sel != null) curService.delete(sel);
                    dcurrency.setEnabled(false);
                    ucurrency.setEnabled(false);
                    List<currency> culist = curService.getAll();
                    curmap.clear();
                    for (currency cu: culist)
                    {
                        curmap.put(cu.getName(), cu);
                    }
                    curridmatter.removeAllItems();
                    curridmatter.addItems(curmap.keySet());
                    rcurrency.setContainerDataSource(new BeanItemContainer<>(currency.class, culist));
                });
                ucurrency.addClickListener( u-> {
                    if (sel != null) if (!ncurrency.equals("")) {sel.setName(ncurrency.getValue());curService.update(sel);}
                    dcurrency.setEnabled(false);
                    ucurrency.setEnabled(false);
                    List<currency> culist = curService.getAll();
                    curmap.clear();
                    for (currency cu: culist)
                    {
                      curmap.put(cu.getName(), cu);
                    }
                    curridmatter.removeAllItems();
                    curridmatter.addItems(curmap.keySet());
                    rcurrency.setContainerDataSource(new BeanItemContainer<>(currency.class, culist));
                });
            }
        });
        rmatter.addSelectionListener(e -> {
            matter select = (matter)rmatter.getSelectedRow();
            if (select != null) {
                dmatter.setEnabled(true);
                umatter.setEnabled(true);
                dmatter.addClickListener(d -> {
                    if (select != null) matService.delete(select);
                    dmatter.setEnabled(false);
                    umatter.setEnabled(false);
                    List<matter> mlist = matService.getAll();
                    rmatter.setContainerDataSource(new BeanItemContainer<>(matter.class, mlist));
                });
                umatter.addClickListener( u->{
                    if (select != null) if (!nmatter.equals(""))
                    {
                        select.setName(nmatter.getValue());
                        if (wmatter.equals(""))
                            select.setWidth(0); else select.setWidth(Integer.parseInt(wmatter.getValue()));
                        if (lmatter.equals(""))
                            select.setLenght(0); else select.setLenght(Integer.parseInt(lmatter.getValue()));
                        if (denmatter.equals(""))
                            select.setDensity(0); else select.setDensity(Integer.parseInt(denmatter.getValue()));
                        Double dd = new Double(0.0);
                        if (pmatter.equals(""))
                            select.setPrice(dd); else select.setPrice(Double.parseDouble(pmatter.getValue()));

                        select.setCurrmt(curmap.get((String)curridmatter.getValue()));
                        select.setMeid(memap.get((String)meidmatter.getValue()));
                        select.setMtid(mtmap.get((String)mtidmatter.getValue()));
                        matService.update(select);
                    }
                    dmatter.setEnabled(false);
                    umatter.setEnabled(false);
                    List<matter> mlist = matService.getAll();
                    rmatter.setContainerDataSource(new BeanItemContainer<>(matter.class, mlist));
                });
            }
        });




        crudcolor.addComponents(ncolor,acolor,gcolor,rcolor,dcolor,ucolor);
        crudcurrency.addComponents(ncurrency,acurrency,gcurrency,rcurrency,dcurrency,ucurrency);

        statmatter.addComponents(nmatter,lmatter,wmatter,denmatter,pmatter,mtidmatter,meidmatter,curridmatter);
        buttonmatter.addComponents(amatter,gmatter,dmatter,umatter);
        gridmatter.addComponent(rmatter);
        crudmatter.addComponents(statmatter,buttonmatter,gridmatter);


        layout.addComponents(crudcolor, crudcurrency, crudmatter);
        layout.setMargin(true);
        layout.setSpacing(true);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
