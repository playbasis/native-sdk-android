package com.playbasis.pbcore.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.playbasis.pbcore.rest.response.GoodsResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 6/21/16 AD.
 */
public class Goods extends PBModel {

  protected String goodsId;
  protected String name;
  protected String description;
  protected String imageUrl;
  protected String group;
  protected List<String> codes;
  protected List<String> tags;
  protected Date startDate;
  protected Date expireDate;
  protected int quantity;
  protected int amount;
  protected int sortOrder;
  protected boolean isGroup;
  protected boolean sponsor;
  protected RedeemCondition redeemCondition;

  @Override
  public boolean equals(Object o) {
    if (o instanceof Goods) {
      String goodsId = ((Goods) o).getGoodsId();

      return goodsId != null && goodsId.equals(getGoodsId());
    }

    return super.equals(o);
  }

  public Goods() {

  }

  public Goods(GoodsResponse response) {
    update(response);
  }

  public static ArrayList<Goods> createGoods(List<GoodsResponse> responses) {
    ArrayList<Goods> goodsList = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return goodsList;
    }

    for (GoodsResponse goodsResponse : responses) {
      goodsList.add(new Goods(goodsResponse));
    }

    return goodsList;
  }

  public void update(GoodsResponse response) {
    if (response == null) {
      return;
    }

    this.goodsId = valueOrDefault(response.goodsId, goodsId);
    this.name = response.name;
    this.description = response.description;
    this.quantity = response.quantity;
    this.amount = response.amount;
    this.imageUrl = response.imageUrl;
    this.tags = response.tags;
    this.codes = response.getCodes();
    this.group = response.group;
    this.startDate = response.startDate;
    this.expireDate = response.expireDate;
    this.isGroup = response.isGroup;
    this.sponsor = response.sponsor;
    this.sortOrder = response.sortOrder;

    if (response.getRedeemConditionResponse() != null) {
      this.redeemCondition = new RedeemCondition(response.getRedeemConditionResponse());
    }
  }

  public String getGoodsId() {
    return goodsId;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public List<String> getCodes() {
    return codes;
  }

  public List<String> getTags() {
    return tags;
  }

  public String getGroup() {
    return group;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Date getExpireDate() {
    return expireDate;
  }

  public boolean isGroup() {
    return isGroup;
  }

  public boolean isSponsor() {
    return sponsor;
  }

  public int getSortOrder() {
    return sortOrder;
  }

  public int getAmount() {
    return amount;
  }

  public RedeemCondition getRedeemCondition() {
    return redeemCondition;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.goodsId);
    dest.writeString(this.name);
    dest.writeString(this.description);
    dest.writeString(this.imageUrl);
    dest.writeString(this.group);
    dest.writeStringList(this.codes);
    dest.writeStringList(this.tags);
    dest.writeLong(this.startDate != null ? this.startDate.getTime() : -1);
    dest.writeLong(this.expireDate != null ? this.expireDate.getTime() : -1);
    dest.writeInt(this.quantity);
    dest.writeInt(this.amount);
    dest.writeInt(this.sortOrder);
    dest.writeByte(this.isGroup ? (byte) 1 : (byte) 0);
    dest.writeByte(this.sponsor ? (byte) 1 : (byte) 0);
    dest.writeParcelable(this.redeemCondition, flags);
  }

  protected Goods(Parcel in) {
    this.goodsId = in.readString();
    this.name = in.readString();
    this.description = in.readString();
    this.imageUrl = in.readString();
    this.group = in.readString();
    this.codes = in.createStringArrayList();
    this.tags = in.createStringArrayList();
    long tmpStartDate = in.readLong();
    this.startDate = tmpStartDate == -1 ? null : new Date(tmpStartDate);
    long tmpExpireDate = in.readLong();
    this.expireDate = tmpExpireDate == -1 ? null : new Date(tmpExpireDate);
    this.quantity = in.readInt();
    this.amount = in.readInt();
    this.sortOrder = in.readInt();
    this.isGroup = in.readByte() != 0;
    this.sponsor = in.readByte() != 0;
    this.redeemCondition = in.readParcelable(RedeemCondition.class.getClassLoader());
  }

  public static final Creator<Goods> CREATOR = new Creator<Goods>() {
    @Override
    public Goods createFromParcel(Parcel source) {
      return new Goods(source);
    }

    @Override
    public Goods[] newArray(int size) {
      return new Goods[size];
    }
  };

  public static class RedeemCondition implements Parcelable {

    protected PointCondition pointCondition;
    protected ArrayList<CustomCondition> customConditions;

    public RedeemCondition(GoodsResponse.RedeemConditionResponse response) {
      if (response.pointCondition != null) {
        pointCondition = new PointCondition(response.pointCondition);
      }

      if (response.customConditionResponses != null) {
        this.customConditions = new ArrayList<>();
        for (GoodsResponse.RedeemConditionResponse.CustomCondition customCondition : response.customConditionResponses) {
          this.customConditions.add(new CustomCondition(customCondition));
        }
      }
    }

    public PointCondition getPointCondition() {
      return pointCondition;
    }

    public ArrayList<CustomCondition> getCustomConditions() {
      return customConditions;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeParcelable(this.pointCondition, flags);
      dest.writeTypedList(this.customConditions);
    }

    protected RedeemCondition(Parcel in) {
      this.pointCondition = in.readParcelable(PointCondition.class.getClassLoader());
      this.customConditions = in.createTypedArrayList(CustomCondition.CREATOR);
    }

    public static final Creator<RedeemCondition> CREATOR = new Creator<RedeemCondition>() {
      @Override
      public RedeemCondition createFromParcel(Parcel source) {
        return new RedeemCondition(source);
      }

      @Override
      public RedeemCondition[] newArray(int size) {
        return new RedeemCondition[size];
      }
    };

    public static class PointCondition implements Parcelable {
      protected int value;

      public PointCondition(GoodsResponse.RedeemConditionResponse.PointCondition pointCondition) {
        this.value = pointCondition.value;
      }

      public int getValue() {
        return value;
      }

      @Override
      public int describeContents() {
        return 0;
      }

      @Override
      public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.value);
      }

      protected PointCondition(Parcel in) {
        this.value = in.readInt();
      }

      public static final Creator<PointCondition> CREATOR = new Creator<PointCondition>() {
        @Override
        public PointCondition createFromParcel(Parcel source) {
          return new PointCondition(source);
        }

        @Override
        public PointCondition[] newArray(int size) {
          return new PointCondition[size];
        }
      };
    }


    public static class CustomCondition implements Parcelable {
      protected String id;
      protected String name;
      protected int value;

      public CustomCondition(GoodsResponse.RedeemConditionResponse.CustomCondition customCondition) {
        this.id = customCondition.customId;
        this.name = customCondition.customName;
        this.value = customCondition.customValue;
      }

      public String getId() {
        return id;
      }

      public String getName() {
        return name;
      }

      public int getValue() {
        return value;
      }

      @Override
      public int describeContents() {
        return 0;
      }

      @Override
      public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.value);
      }

      protected CustomCondition(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.value = in.readInt();
      }

      public static final Creator<CustomCondition> CREATOR = new Creator<CustomCondition>() {
        @Override
        public CustomCondition createFromParcel(Parcel source) {
          return new CustomCondition(source);
        }

        @Override
        public CustomCondition[] newArray(int size) {
          return new CustomCondition[size];
        }
      };
    }
  }
}
