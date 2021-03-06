package com.example.aisensample.ui.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.aisensample.R;
import com.example.aisensample.support.bean.MenuBean;
import com.example.aisensample.ui.activity.MainActivity;
import com.m.support.adapter.ABaseAdapter;
import com.m.support.inject.ViewInject;
import com.m.ui.fragment.AListFragment;

import java.util.ArrayList;

/**
 * Created by wangdan on 15/4/23.
 */
public class MenuFragment extends AListFragment<MenuBean, ArrayList<MenuBean>> {

    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    @Override
    protected ABaseAdapter.AbstractItemView<MenuBean> newItemView() {
        return new MainItemView();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ((MainActivity) getActivity()).onMenuSelected(getAdapterItems().get(position));
    }

    @Override
    protected void requestData(RefreshMode mode) {
        setItems(generateItems());

        onItemClick(getRefreshView(), null, 0, 0);
    }

    private ArrayList<MenuBean> generateItems() {
        ArrayList<MenuBean> items = new ArrayList<MenuBean>();

        items.add(new MenuBean(0, R.string.a_base_fragment, R.string.a_base_fragment, "0"));

        return items;
    }

    class MainItemView extends ABaseAdapter.AbstractItemView<MenuBean> {

        @ViewInject(id = R.id.txtTitle)
        TextView txtTitle;

        @Override
        public int inflateViewId() {
            return R.layout.item_main;
        }

        @Override
        public void bindingData(View convertView, MenuBean data) {
            txtTitle.setText(data.getTitleRes());
        }

    }

}
