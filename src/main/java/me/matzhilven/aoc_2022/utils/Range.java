package me.matzhilven.aoc_2022.utils;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public final class Range<T> implements Serializable {
    private final Comparator<T> comparator;
    private final T maximum;
    private final T minimum;

    private Range(T element1, T element2, Comparator<T> comp) {
        if (element1 != null && element2 != null) {
            this.comparator = Objects.requireNonNullElse(comp, ComparableComparator.INSTANCE);

            if (this.comparator.compare(element1, element2) < 1) {
                this.minimum = element1;
                this.maximum = element2;
            } else {
                this.minimum = element2;
                this.maximum = element1;
            }

        } else {
            throw new IllegalArgumentException("Elements in a range must not be null: element1=" + element1 + ", element2=" + element2);
        }
    }

    public static <T extends Comparable<T>> Range<T> between(T fromInclusive, T toInclusive) {
        return between(fromInclusive, toInclusive, null);
    }

    public static <T> Range<T> between(T fromInclusive, T toInclusive, Comparator<T> comparator) {
        return new Range<>(fromInclusive, toInclusive, comparator);
    }

    public boolean contains(T element) {
        if (element == null) {
            return false;
        } else {
            return this.comparator.compare(element, this.minimum) > -1 && this.comparator.compare(element, this.maximum) < 1;
        }
    }

    public boolean isOverlappedBy(Range<T> otherRange) {
        if (otherRange == null) {
            return false;
        } else {
            return otherRange.contains(this.minimum) || otherRange.contains(this.maximum) || this.contains(otherRange.minimum);
        }
    }

    public boolean containsRange(Range<T> otherRange) {
        if (otherRange == null) {
            return false;
        } else {
            return this.contains(otherRange.minimum) && this.contains(otherRange.maximum);
        }
    }

    private enum ComparableComparator implements Comparator {
        INSTANCE;

        ComparableComparator() {
        }

        public int compare(Object obj1, Object obj2) {
            return ((Comparable) obj1).compareTo(obj2);
        }
    }
}
