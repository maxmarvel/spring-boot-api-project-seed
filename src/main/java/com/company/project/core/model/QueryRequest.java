package com.company.project.core.model;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Chen
 * @created 2019-05-22-11:32.
 */
@Getter
@Setter
public class QueryRequest implements Serializable {
    private int pageSize;
    private int pageNum;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("pageSize", pageSize)
                .add("pageNum", pageNum)
                .toString();
    }

}
