package com.runescape.api.ge.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.runescape.api.ge.GrandExchange;

import java.util.Arrays;

/**
 * Represents the information of an item category on the RuneScape {@link GrandExchange}.
 * @see <a href="http://services.runescape.com/m=rswiki/en/Grand_Exchange_APIs#Category_information_details">Category information details</a>
 */
public final class Category {
	/**
	 * The amount of items on each {@link Category} page.
	 */
	public static final int ITEMS_PER_PAGE = 12;

	/**
	 * The types of item within this category.
	 */
	private final Object[] types;

	/**
	 * The search results within this category.
	 */
	private final SearchResult[] alpha;

	/**
	 * Creates a new {@link Category}
	 * @param types The types of item.
	 * @param alpha The search results.
	 */
	public Category(Object[] types, SearchResult[] alpha) {
		this.types = Preconditions.checkNotNull(types).clone();
		this.alpha = Preconditions.checkNotNull(alpha).clone();
	}

	/**
	 * Gets an {@link ImmutableList} of the types of item within this category.
	 * @return An {@link ImmutableList} of the types of item within this category.
	 */
	public ImmutableList<Object> getTypes() {
		return ImmutableList.copyOf(types);
	}

	/**
	 * Gets an {@link ImmutableList} of the {@link SearchResult}s within this category.
	 * @return An {@link ImmutableList} of the {@link SearchResult}s within this category
	 */
	public ImmutableList<SearchResult> getAlpha() {
		return ImmutableList.copyOf(alpha);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("types", Arrays.toString(types))
			.add("alpha", Arrays.toString(alpha))
			.toString();
	}
}
