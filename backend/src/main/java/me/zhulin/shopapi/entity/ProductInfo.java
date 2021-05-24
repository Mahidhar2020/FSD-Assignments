package me.zhulin.shopapi.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created By Zhu Lin on 3/10/2018.
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {
    @Id
    private String productId;

    /** 名字. */
    @NotNull
    private String productName;

    /** 单价. */
    @NotNull
    private BigDecimal productPrice;

    /** 库存. */
    @NotNull
    @Min(0)
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 0: on-sale 1: off-sale */

    @ColumnDefault("0")
    private Integer productStatus;


   /** 类目编号. */
    @ColumnDefault("0")
    private Integer categoryType;

    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;

    public ProductInfo() {
    }

	public String getProductId() {
		// TODO Auto-generated method stub
		return null;
	}

	public @NotEmpty String getProductName() {
		// TODO Auto-generated method stub
		return null;
	}

	public @NotNull String getProductDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProductIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	public @NotNull BigDecimal getProductPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	public @NotNull Integer getCategoryType() {
		// TODO Auto-generated method stub
		return null;
	}

	public @Min(0) Integer getProductStock() {
		// TODO Auto-generated method stub
		return null;
	}
}
