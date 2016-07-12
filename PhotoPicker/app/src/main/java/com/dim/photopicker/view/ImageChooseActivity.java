package com.dim.photopicker.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.dim.photopicker.R;
import com.dim.photopicker.adapter.ImageGridAdapter;
import com.dim.photopicker.model.ImageItem;
import com.dim.photopicker.util.CustomConstants;
import com.dim.photopicker.util.IntentConstants;
import com.dim.photopicker.util.RunTimeData;

/**
 * 图片选择
 * 
 */
public class ImageChooseActivity extends BaseActivity {
    private List<ImageItem> mDataList    = new ArrayList<ImageItem>();
    private String               mBucketName;
    private int                  availableSize;
    private GridView             mGridView;
    private TextView             mBucketNameTv;
    private TextView             cancelTv;
    private ImageGridAdapter mAdapter;
    private Button               mFinishBtn;
    private ArrayList<ImageItem> selectedImgs = new ArrayList<ImageItem>();

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_image_choose);
        mDataList = (List<ImageItem>) getIntent().getSerializableExtra(IntentConstants.EXTRA_IMAGE_LIST);
        if (mDataList == null)
            mDataList = new ArrayList<ImageItem>();
        mBucketName = getIntent().getStringExtra(IntentConstants.EXTRA_BUCKET_NAME);

        if (TextUtils.isEmpty(mBucketName)) {
            mBucketName = "请选择";
        }
        availableSize = getIntent().getIntExtra(IntentConstants.EXTRA_CAN_ADD_IMAGE_SIZE, CustomConstants.MAX_IMAGE_SIZE);

        initView();
        initListener();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void initView() {
        mBucketNameTv = (TextView) findViewById(R.id.title);
        mBucketNameTv.setText(mBucketName);

        mGridView = (GridView) findViewById(R.id.gridview);
        mGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        mAdapter = new ImageGridAdapter(ImageChooseActivity.this, mDataList);
        mGridView.setAdapter(mAdapter);
        mFinishBtn = (Button) findViewById(R.id.finish_btn);
        cancelTv = (TextView) findViewById(R.id.action);

        mFinishBtn.setText("完成" + "(" + selectedImgs.size() + "/" + availableSize + ")");
        mAdapter.notifyDataSetChanged();
    }

    private void initListener() {
        mFinishBtn.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(IntentConstants.EXTRA_IMAGE_LIST, (Serializable) selectedImgs);
                setResult(CustomConstants.RESULT_PICTURE_BACK, intent);
                RunTimeData.getInstance().setChoseImage(selectedImgs);
                ImageChooseActivity.this.finish();
            }

        });

        mGridView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageItem item = mDataList.get(position);
                if (item.isSelected) {
                    item.isSelected = false;
                    for (int i = selectedImgs.size() - 1; i >= 0; i--) {
                        if (selectedImgs.get(i).imageId.equals(item.imageId)) {
                            selectedImgs.remove(i);
                        }
                    }
                } else {
                    if (selectedImgs.size() >= availableSize) {
                        Toast.makeText(ImageChooseActivity.this, "最多选择" + availableSize + "张图片", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    item.isSelected = true;
                    selectedImgs.add(item);
                }

                mFinishBtn.setText("完成" + "(" + selectedImgs.size() + "/" + availableSize + ")");
                mAdapter.notifyDataSetChanged();
            }

        });

        cancelTv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                ImageChooseActivity.this.finish();
            }
        });

    }
}